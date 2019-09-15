package com.cts.projectmanager.controller;

import com.cts.projectmanager.dto.ProjectDTO;
import com.cts.projectmanager.service.IProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest Controller for Project changes
 *
 * @author Ramakrishna Gurram
 */
@CrossOrigin("*")
@RestController
public class ProjectController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);
    private IProjectService projectService;

    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(value = "/project", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    List<ProjectDTO> fetchProjects() {
        LOGGER.debug("fetchProjects() start method");
        List<ProjectDTO> response = projectService.fetchProject();
        LOGGER.debug("fetchProjects() end method");
        return response;
    }

    @RequestMapping(value = "/project", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    List<ProjectDTO> addProject(@RequestBody ProjectDTO project) {
        LOGGER.debug("fetchProjects() start method");
        List<ProjectDTO> response = projectService.addProject(project);
        LOGGER.debug("fetchProjects() end method");
        return response;
    }

    @RequestMapping(value = "/project", method = RequestMethod.DELETE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    List<ProjectDTO> deleteProject(@RequestBody ProjectDTO project) {
        LOGGER.debug("fetchProjects() start method");
        List<ProjectDTO> response = projectService.deleteProject(project);
        LOGGER.debug("fetchProjects() end method");
        return response;
    }
}
