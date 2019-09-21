package com.cts.projectmanager.service;

import com.cts.projectmanager.domain.IProjectDomain;
import com.cts.projectmanager.dto.ProjectDTO;
import com.cts.projectmanager.dto.ProjectResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service Class to add edit delete projects
 */
@Service
public class ProjectServiceImpl implements IProjectService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectServiceImpl.class);
    private IProjectDomain projectDomain;

    public ProjectServiceImpl(IProjectDomain projectDomain) {
        this.projectDomain = projectDomain;
    }

    /**
     * Method to fetch Projects
     *
     * @return
     */
    @Override
    public List<ProjectResponseDTO> fetchProject() {
        LOGGER.debug("fetchProject() method start");
        List<ProjectResponseDTO> response = projectDomain.fetchProjects();
        LOGGER.debug("fetchProject() method end");
        return response;
    }

    /**
     * Method to add Project
     *
     * @param project
     * @return
     */
    @Override
    public List<ProjectResponseDTO> addProject(ProjectDTO project) {
        LOGGER.debug("addProject() method start");
        List<ProjectResponseDTO> response = projectDomain.addProject(project);
        LOGGER.debug("addProject() method end");
        return response;
    }

    /**
     * Method to delete Project
     *
     * @param project
     * @return
     */
    @Override
    public List<ProjectResponseDTO> deleteProject(ProjectDTO project) {
        LOGGER.debug("deleteProject() method start");
        List<ProjectResponseDTO> response = projectDomain.deleteProject(project);
        LOGGER.debug("deleteProject() method end");
        return response;
    }
}
