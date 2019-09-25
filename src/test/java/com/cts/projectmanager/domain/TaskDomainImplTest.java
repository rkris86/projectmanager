package com.cts.projectmanager.domain;

import com.cts.projectmanager.dto.ParentTaskDTO;
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
import org.apache.catalina.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
public class TaskDomainImplTest {
    @MockBean
    TaskDomainImpl taskDomain;
    @MockBean
    ITaskRepository taskRepository;
    @MockBean
    IParentRepository parentRepository;
    @MockBean
    IUsersRepository usersRepository;
    @MockBean
    IProjectRepository projectRepository;
    List<ParentTaskDTO> parentTaskDTOS = new ArrayList<>();
    ParentTaskDTO parentTaskDTO = null;
    List<TaskDTO> taskDTOS = new ArrayList<>();
    TaskDTO taskDTO = null;

    List<ParentEO> parentEOS = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        parentTaskDTO = new ParentTaskDTO(null, "Parent Task ");
        parentTaskDTOS.add(parentTaskDTO);

        taskDTO = new TaskDTO();
        taskDTO.setStatus("pending");
        taskDTO.setTaskId(1l);
        taskDTO.setStartDate("2019-09-22");
        taskDTO.setEndDate("2019-10-22");
        taskDTO.setTask("Task one");
        taskDTO.setPriority(10);
        taskDTO.setParentTask(parentTaskDTO);
        taskDTOS.add(taskDTO);
        /***************************************************************************/
        ParentEO parentEO = new ParentEO();
        parentEO.setParentId(1l);
        parentEO.setParentTask("Parent one");
        parentEOS.add(parentEO);

        UserDTO user = new UserDTO();
        user.setUserId(1);
        taskDTO.setUser(user);

        taskDomain = new TaskDomainImpl(taskRepository, parentRepository, usersRepository, projectRepository);
    }

    @Test
    public void fetchParentTasks() {
        Mockito.when(parentRepository.findAll()).thenReturn(parentEOS);
        assertNotNull(taskDomain.fetchParentTasks());
    }

    @Test
    public void addParentTask() {
        ParentEO parentEO = new ParentEO();
        parentEO.setParentTask("Parent Task ");

        Mockito.when(parentRepository.saveAndFlush(parentEO)).thenReturn(parentEO);
        assertNotNull(taskDomain.addParentTask(parentTaskDTO));
    }

    @Test
    public void fetchTasks() {
        ParentEO parentEO = new ParentEO();
        parentEO.setParentTask("Parent Task");
        parentEO.setParentId(1l);

        ProjectEO projectEO = new ProjectEO();
        projectEO.setProjectId(1l);
        projectEO.setProject("Project One");
        projectEO.setPriority(10);
        projectEO.setStartDate(Date.valueOf("2019-09-22"));
        projectEO.setEndDate(Date.valueOf("2019-09-23"));

        UsersEO usersEO = new UsersEO();
        usersEO.setEmployeeId(78945);
        usersEO.setFirstName("First Name");
        usersEO.setLastName("Last Name");
        usersEO.setUserId(1);

        List<TaskEO> taskEOS = new ArrayList<>();
        TaskEO taskEO = new TaskEO();
        taskEO.setTaskId(1l);
        taskEO.setTask("Task one");
        taskEO.setPriority(10);
        taskEO.setStartDate(Date.valueOf("2019-09-22"));
        taskEO.setEndDate(Date.valueOf("2019-09-23"));
        taskEO.setParent(parentEO);
        taskEO.setProject(projectEO);
        taskEO.setUser(usersEO);
        taskEOS.add(taskEO);

        Mockito.when(taskRepository.findAll()).thenReturn(taskEOS);
        assertNotNull(taskDomain.fetchTasks());
    }

    @Test
    public void addTask() {
        ParentEO parentEO = new ParentEO();
        parentEO.setParentTask("Parent Task");
        parentEO.setParentId(1l);

        ProjectEO projectEO = new ProjectEO();
        projectEO.setProjectId(1l);
        projectEO.setProject("Project One");
        projectEO.setPriority(10);
        projectEO.setStartDate(Date.valueOf("2019-09-22"));
        projectEO.setEndDate(Date.valueOf("2019-09-23"));

        TaskEO taskEO = new TaskEO();
        taskEO.setTaskId(1l);
        taskEO.setTask("Task one");
        taskEO.setPriority(10);
        taskEO.setStartDate(Date.valueOf("2019-09-22"));
        taskEO.setEndDate(Date.valueOf("2019-09-23"));
        taskEO.setProject(projectEO);
        taskEO.setParent(parentEO);
        UsersEO usersEO = new UsersEO();
        usersEO.setUserId(1);
        Mockito.when(taskRepository.saveAndFlush(taskEO)).thenReturn(taskEO);
        Mockito.when(usersRepository.findUsersEOByUserId(taskDTO.getUser().getUserId())).thenReturn(usersEO);
        usersEO.setTask(taskEO);
        Mockito.when(usersRepository.saveAndFlush(usersEO)).thenReturn(usersEO);
        taskDTO.getParentTask().setParentId(1l);
        assertNotNull(taskDomain.addTask(taskDTO));

    }

    @Test
    public void fetchTask() {
        ParentEO parentEO = new ParentEO();
        parentEO.setParentTask("Parent Task");
        parentEO.setParentId(1l);

        ProjectEO projectEO = new ProjectEO();
        projectEO.setProjectId(1l);
        projectEO.setProject("Project One");
        projectEO.setPriority(10);
        projectEO.setStartDate(Date.valueOf("2019-09-22"));
        projectEO.setEndDate(Date.valueOf("2019-09-23"));

        UsersEO usersEO = new UsersEO();
        usersEO.setEmployeeId(78945);
        usersEO.setFirstName("First Name");
        usersEO.setLastName("Last Name");
        usersEO.setUserId(1);

        List<TaskEO> taskEOS = new ArrayList<>();
        TaskEO taskEO = new TaskEO();
        taskEO.setTaskId(1l);
        taskEO.setTask("Task one");
        taskEO.setPriority(10);
        taskEO.setStartDate(Date.valueOf("2019-09-22"));
        taskEO.setEndDate(Date.valueOf("2019-09-23"));
        taskEO.setParent(parentEO);

        taskEO.setUser(usersEO);
        taskEOS.add(taskEO);
        projectEO.setTasks(taskEOS);
        Mockito.when(projectRepository.findProjectEOByProjectId(1l)).thenReturn(projectEO);
        assertNotNull(taskDomain.fetchTask(1l));
    }

    @Test
    public void completeTask() {
        TaskEO taskEO = new TaskEO();
        taskEO.setTaskId(1l);
        taskEO.setTask("Task one");
        taskEO.setPriority(10);
        taskEO.setStartDate(Date.valueOf("2019-09-22"));
        taskEO.setEndDate(Date.valueOf("2019-09-23"));

        Mockito.when(taskRepository.findTaskEOSByTaskId(1l)).thenReturn(taskEO);
        taskEO.setStatus("completed");
        Mockito.when(taskRepository.saveAndFlush(taskEO)).thenReturn(taskEO);
        ProjectEO projectEO = new ProjectEO();
        projectEO.setProjectId(1l);
        projectEO.setProject("Project One");
        projectEO.setPriority(10);
        projectEO.setStartDate(Date.valueOf("2019-09-22"));
        projectEO.setEndDate(Date.valueOf("2019-09-23"));

        taskEO.setProject(projectEO);
        List<TaskEO> taskEOS = new ArrayList<>();
        taskEOS.add(taskEO);
        projectEO.setTasks(taskEOS);
        Mockito.when(projectRepository.findProjectEOByProjectId(1l)).thenReturn(projectEO);
        assertNotNull(taskDomain.completeTask(1l));

    }
}