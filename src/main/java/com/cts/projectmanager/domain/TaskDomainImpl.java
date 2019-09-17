package com.cts.projectmanager.domain;

import com.cts.projectmanager.dto.ParentTaskDTO;
import com.cts.projectmanager.dto.TaskDTO;
import com.cts.projectmanager.eo.ParentEO;
import com.cts.projectmanager.eo.TaskEO;
import com.cts.projectmanager.repository.IParentRepository;
import com.cts.projectmanager.repository.ITaskRepository;
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

    @Autowired
    public TaskDomainImpl(ITaskRepository taskRepository, IParentRepository parentRepository) {
        this.taskRepository = taskRepository;
        this.parentRepository = parentRepository;
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
            ParentTaskDTO parent = new ParentTaskDTO(parentEO.getProjectId(), parentEO.getParentTask());
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
        for (TaskEO taskEO        : taskEOS) {
            TaskDTO task = new TaskDTO();
            task.setTaskId(taskEO.getTaskId());
            task.setTask(taskEO.getTask());
            task.setStartDate(taskEO.getStartDate().toString());
            task.setEndDate(taskEO.getEndDate().toString());
            task.setPriority(taskEO.getPriority());
            task.setProjectId(taskEO.getProjectId());
            task.setParentId(taskEO.getParentId());
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
        return null;
    }

    /**
     * Method to edit Task
     *
     * @param task
     * @return
     */
    @Override
    public List<TaskDTO> editTask(TaskDTO task) {
        return null;
    }

    /**
     * Method to delete Task
     *
     * @param task
     * @return
     */
    @Override
    public List<TaskDTO> deleteTask(TaskDTO task) {
        return null;
    }
}
