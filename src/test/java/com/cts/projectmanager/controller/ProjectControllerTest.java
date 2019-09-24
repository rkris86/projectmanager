package com.cts.projectmanager.controller;

import com.cts.projectmanager.dto.ProjectDTO;
import com.cts.projectmanager.dto.ProjectResponseDTO;
import com.cts.projectmanager.service.ProjectServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
public class ProjectControllerTest {
    @MockBean
    ProjectServiceImpl projectService;

    @MockBean
    ProjectController projectController;

    List<ProjectResponseDTO> projectDTOS = new ArrayList<>();
    ProjectResponseDTO projectDTO = null;
    ProjectDTO project = null;
    @Before
    public void setUp() throws Exception{
        projectDTO = new ProjectResponseDTO();
        projectDTO.setPriority(2);
        projectDTO.setProject("productId");
        projectDTO.setProjectId(1l);
        projectDTOS.add(projectDTO);
        project = new ProjectDTO();
        project.setProjectId(2l);
        project.setProject("project two");

        projectController = new ProjectController(projectService);
    }
    @Test
    public void fetchProjects() {
        Mockito.when(projectService.fetchProject()).thenReturn(projectDTOS);
        assertNotNull(projectController.fetchProjects());
    }

    @Test
    public void addProject() {
        Mockito.when(projectService.addProject(project)).thenReturn(projectDTOS);
        assertNotNull(projectController.addProject(project));
    }

    @Test
    public void deleteProject() {
        Mockito.when(projectService.deleteProject(project)).thenReturn(projectDTOS);
        assertNotNull(projectController.deleteProject(project));
    }
}