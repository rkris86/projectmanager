package com.cts.projectmanager.domain;

import com.cts.projectmanager.dto.ProjectDTO;
import com.cts.projectmanager.dto.ProjectResponseDTO;
import com.cts.projectmanager.eo.ParentEO;
import com.cts.projectmanager.eo.ProjectEO;
import com.cts.projectmanager.eo.TaskEO;
import com.cts.projectmanager.eo.UsersEO;
import com.cts.projectmanager.repository.IProjectRepository;
import com.cts.projectmanager.repository.ITaskRepository;
import com.cts.projectmanager.repository.IUsersRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
public class ProjectDomainImplTest {
    @MockBean
    IProjectRepository projectRepository;
    @MockBean
    IUsersRepository usersRepository;
    @MockBean
    ITaskRepository taskRepository;

    @MockBean
    ProjectDomainImpl projectDomain;

    List<ProjectResponseDTO> responseDTOs = new ArrayList<>();
    ProjectResponseDTO responseDTO = null;
    List<ProjectEO> projectEOS = new ArrayList<>();
    ProjectDTO requestOne = null;
    ProjectDTO requestTwo = null;
    UsersEO user = null;
    ProjectEO addProjectEO = null;
    ProjectEO projectEO = null;

    @Before
    public void setUp() throws Exception {
        user = new UsersEO();
        user.setUserId(1);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setEmployeeId(7897854);

        ParentEO parentEO = new ParentEO();
        parentEO.setParentId(1);
        parentEO.setParentTask("Parent Task");

        List<TaskEO> taskEOS = new ArrayList<>();
        TaskEO taskEO = new TaskEO();
        taskEO.setStatus("completed");
        taskEO.setTask("Task one");
        taskEO.setTaskId(1);
        taskEO.setStartDate(new Date(LocalDate.now().toEpochDay()));
        taskEO.setEndDate(new Date(LocalDate.now().toEpochDay()));
        taskEO.setParent(parentEO);
        TaskEO taskEO2 = new TaskEO();
        taskEO2.setStatus(null);
        taskEO2.setTask("Task two");
        taskEO2.setTaskId(2);
        taskEO2.setStartDate(new Date(LocalDate.now().toEpochDay()));
        taskEO2.setEndDate(new Date(LocalDate.now().toEpochDay()));
        taskEO2.setParent(parentEO);
        taskEOS.add(taskEO);
        taskEOS.add(taskEO2);

        projectEO = new ProjectEO();
        projectEO.setProjectId(1);
        projectEO.setProject("Project One");
        projectEO.setEndDate(new Date(LocalDate.now().toEpochDay()));
        projectEO.setStartDate(new Date(LocalDate.now().toEpochDay()));
        projectEO.setPriority(20);
        projectEO.setUser(user);
        projectEO.setTasks(taskEOS);
        projectEOS.add(projectEO);
        projectDomain = new ProjectDomainImpl(projectRepository, usersRepository, taskRepository);

        requestOne = new ProjectDTO();
        requestOne.setProject("Project One");
        requestOne.setUser(1);
        requestOne.setPriority(20);
        requestOne.setStartDate("2019-09-22");
        requestOne.setEndDate("2019-10-22");

        addProjectEO = new ProjectEO();
        addProjectEO.setProjectId(1);
        addProjectEO.setProject("Project One");
        addProjectEO.setEndDate(Date.valueOf("2019-10-22"));
        addProjectEO.setStartDate(Date.valueOf("2019-09-22"));
        addProjectEO.setPriority(20);

        requestTwo = new ProjectDTO();
        requestTwo.setProject("Project One");
        requestTwo.setProjectId(1l);
        requestTwo.setUser(1);
        requestTwo.setPriority(20);
        requestTwo.setStartDate("2019-09-22");
        requestTwo.setEndDate("2019-10-22");
    }

    @Test
    public void fetchProjects() {
        Mockito.when(projectRepository.findAll()).thenReturn(projectEOS);
        assertNotNull(projectDomain.fetchProjects());
    }

    @Test
    public void addProject() {
        Mockito.when(usersRepository.findUsersEOByUserId(1)).thenReturn(user);
        Mockito.when(projectRepository.saveAndFlush(addProjectEO)).thenReturn(projectEO);
        user.setProject(projectEO);
        Mockito.when(usersRepository.saveAndFlush(user)).thenReturn(user);
        Mockito.when(projectRepository.findAll()).thenReturn(projectEOS);
        assertNotNull(projectDomain.addProject(requestOne));

        projectEO.setUser(user);
        Mockito.when(projectRepository.findProjectEOByProjectId(1l)).thenReturn(projectEO);
        assertNotNull(projectDomain.addProject(requestTwo));
    }

    @Test
    public void deleteProject() {
        Mockito.when(projectRepository.findProjectEOByProjectId(requestTwo.getProjectId())).thenReturn(projectEO);
        assertNotNull(projectDomain.deleteProject(requestTwo));
    }
}