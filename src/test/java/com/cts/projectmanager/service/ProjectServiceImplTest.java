package com.cts.projectmanager.service;

import com.cts.projectmanager.domain.ProjectDomainImpl;
import com.cts.projectmanager.dto.ProjectDTO;
import com.cts.projectmanager.dto.ProjectResponseDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
@RunWith(SpringRunner.class)
public class ProjectServiceImplTest {
    @MockBean
    ProjectDomainImpl projectDomain;
    @MockBean
    ProjectServiceImpl projectService;
    List<ProjectResponseDTO> projectDTOS = new ArrayList<>();
    ProjectResponseDTO projectDTO = null;
    ProjectDTO project = null;

    @Before
    public void setUp() throws Exception {
        projectDTO = new ProjectResponseDTO();
        projectDTO.setPriority(2);
        projectDTO.setProject("productId");
        projectDTO.setProjectId(1l);
        projectDTOS.add(projectDTO);
        project = new ProjectDTO();
        project.setProjectId(2l);
        project.setProject("project two");
        projectService = new ProjectServiceImpl(projectDomain);
    }

    @Test
    public void fetchProject() {
        Mockito.when(projectDomain.fetchProjects()).thenReturn(projectDTOS);
        assertNotNull(projectService.fetchProject());
    }

    @Test
    public void addProject() {
        Mockito.when(projectDomain.addProject(project)).thenReturn(projectDTOS);
        assertNotNull(projectService.addProject(project));
    }

    @Test
    public void deleteProject() {
        Mockito.when(projectDomain.deleteProject(project)).thenReturn(projectDTOS);
        assertNotNull(projectService.deleteProject(project));
    }
}