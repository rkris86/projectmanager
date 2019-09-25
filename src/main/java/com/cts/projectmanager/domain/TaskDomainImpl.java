package com.cts.projectmanager.domain;

import com.cts.projectmanager.dto.ParentTaskDTO;
import com.cts.projectmanager.dto.ProjectDTO;
import com.cts.projectmanager.dto.TaskDTO;
import com.cts.projectmanager.dto.UserDTO;
import com.cts.projectmanager.eo.ParentEO;
import com.cts.projectmanager.eo.ProjectEO;
import com.cts.projectmanager.eo.TaskEO;
import com.cts.projectmanager.eo.UsersEO;
import com.cts.projectmanager.repository.IParentRepository;
import com.cts.projectmanager.repository.IProjectRepository;
import com.cts.projectmanager.repository.ITaskRepository;
import com.cts.projectmanager.repository.IUsersRepository;
import com.cts.projectmanager.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskDomainImpl implements ITaskDomain {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskDomainImpl.class);
    private ITaskRepository taskRepository;
    private IParentRepository parentRepository;
    private IUsersRepository usersRepository;
    private IProjectRepository projectRepository;

    @Autowired
    public TaskDomainImpl(ITaskRepository taskRepository, IParentRepository parentRepository, IUsersRepository usersRepository, IProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.parentRepository = parentRepository;
        this.usersRepository = usersRepository;
        this.projectRepository = projectRepository;
    }

    /**
     * Method to fetch Parent Tasks;
     *
     * @return
     */
    @Override
    public List<ParentTaskDTO> fetchParentTasks() {
        LOGGER.debug("fetchParentTasks() method start");
        List<ParentEO> parentEOS = parentRepository.findAll();
        List<ParentTaskDTO> response = new ArrayList<>();
        for (ParentEO parentEO : parentEOS) {
            ParentTaskDTO parent = new ParentTaskDTO(parentEO.getParentId(), parentEO.getParentTask());
            response.add(parent);
        }
        LOGGER.debug("fetchParentTasks() method end");
        return response;
    }

    /**
     * Method to Add parent Tasks
     *
     * @param parentTask
     * @return
     */
    @Override
    public List<ParentTaskDTO> addParentTask(ParentTaskDTO parentTask) {
        LOGGER.debug("addParentTask() method start");
        ParentEO parentEO = new ParentEO();
        parentEO.setParentTask(parentTask.getParentTask());
        parentRepository.saveAndFlush(parentEO);
        LOGGER.debug("addParentTask() method end");
        return fetchParentTasks();
    }

    /**
     * Method to Fetch Tasks
     *
     * @return
     */
    @Override
    public List<TaskDTO> fetchTasks() {
        LOGGER.debug("fetchTasks() method start");
        List<TaskEO> taskEOS = taskRepository.findAll();
        List<TaskDTO> response = new ArrayList<>();
        for (TaskEO taskEO : taskEOS) {
            TaskDTO task = new TaskDTO();
            task.setTaskId(taskEO.getTaskId());
            task.setTask(taskEO.getTask());
            task.setStartDate(taskEO.getStartDate().toString());
            task.setEndDate(taskEO.getEndDate().toString());
            task.setPriority(taskEO.getPriority());
            ParentEO parentEO = taskEO.getParent();
            if (parentEO != null) {
                ParentTaskDTO parentTaskDTO = new ParentTaskDTO(parentEO.getParentId(), parentEO.getParentTask());
                task.setParentTask(parentTaskDTO);
            }
            if (null != taskEO.getProject()) {
                ProjectDTO projectDTO = new ProjectDTO();
                projectDTO.setPriority(taskEO.getProject().getPriority());
                projectDTO.setStartDate(taskEO.getProject().getStartDate() != null ? taskEO.getProject().getStartDate().toString() : null);
                projectDTO.setEndDate(taskEO.getProject().getEndDate() != null ? taskEO.getProject().getEndDate().toString() : null);
                projectDTO.setProject(taskEO.getProject().getProject());
                projectDTO.setProjectId(taskEO.getProject().getProjectId());
                task.setProject(projectDTO);
            }
            if (null != taskEO.getUser()) {
                UserDTO user = new UserDTO();
                user.setUserId(taskEO.getUser().getUserId());
                user.setLastName(taskEO.getUser().getLastName());
                user.setFirstName(taskEO.getUser().getFirstName());
                user.setEmployeeId(taskEO.getUser().getEmployeeId());
                task.setUser(user);
            }
            //  task.setProjectId(taskEO.getProjectId());
            //  task.setParentId(taskEO.getParentId());
            response.add(task);
        }
        LOGGER.debug("fetchTasks() method end");
        return response;
    }

    /**
     * Method to add Task
     *
     * @param task
     * @return
     */
    @Override
    public List<TaskDTO> addTask(TaskDTO task) {
        TaskEO taskEO = Utils.createTaskEO(task);
        TaskEO taskResponse = taskRepository.saveAndFlush(taskEO);
        UsersEO userEO = usersRepository.findUsersEOByUserId(task.getUser().getUserId());
        userEO.setTask(taskResponse);
        usersRepository.saveAndFlush(userEO);
        return fetchTasks();
    }

    /**
     * Method to fetch Tasks based on the Project Id
     *
     * @param projectId
     * @return
     */
    @Override
    public List<TaskDTO> fetchTask(Long projectId) {
        ProjectEO projectEO = projectRepository.findProjectEOByProjectId(projectId);
        //List<TaskEO> taskEOS= taskRepository.findTaskEOSByProjectId(projectId);
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectId(projectEO.getProjectId());
        projectDTO.setProject(projectEO.getProject());
        projectDTO.setStartDate(projectEO.getStartDate() != null ? projectEO.getStartDate().toString() : "");
        projectDTO.setEndDate(projectEO.getEndDate() != null ? projectEO.getEndDate().toString() : "");
        projectDTO.setPriority(projectEO.getPriority());
        List<TaskDTO> response = new ArrayList<>();
        for (TaskEO task : projectEO.getTasks()) {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setTaskId(task.getTaskId());
            taskDTO.setTask(task.getTask());
            if (null != task.getParent()) {
                ParentTaskDTO parentTaskDTO = new ParentTaskDTO(task.getParent().getParentId(), task.getParent().getParentTask());
                taskDTO.setParentTask(parentTaskDTO);
            }
            taskDTO.setPriority(task.getPriority());
            taskDTO.setStartDate(task.getStartDate().toString());
            taskDTO.setEndDate(task.getEndDate().toString());
            taskDTO.setStatus(task.getStatus());
            taskDTO.setProject(projectDTO);

            UsersEO usersEO = task.getUser();
            UserDTO userDTO = new UserDTO();
            if (usersEO != null) {
                userDTO.setUserId(usersEO.getUserId());
                userDTO.setFirstName(usersEO.getFirstName());
                userDTO.setLastName(usersEO.getLastName());
                userDTO.setEmployeeId(usersEO.getEmployeeId());
                taskDTO.setUser(userDTO);
            }
            response.add(taskDTO);
        }
        return response;
    }

    /**
     * Method to complete a Task
     *
     * @param taskId
     * @return
     */
    @Override
    public List<TaskDTO> completeTask(Long taskId) {
        TaskEO taskEO = taskRepository.findTaskEOSByTaskId(taskId);
        taskEO.setStatus("completed");
        taskRepository.saveAndFlush(taskEO);
        return fetchTask(taskEO.getProject().getProjectId());
    }
}
