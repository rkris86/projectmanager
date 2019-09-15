package com.cts.projectmanager.service;

import com.cts.projectmanager.dto.ProjectDTO;

import java.util.List;

public interface IProjectService {
    /**
     * Method to fetch Projects
     * @return
     */
    List<ProjectDTO> fetchProject();

    /**
     * Method to add Project
     * @param project
     * @return
     */
    List<ProjectDTO> addProject(ProjectDTO project);

    /**
     * Method to delete Project
     * @param project
     * @return
     */
    List<ProjectDTO> deleteProject(ProjectDTO project);
}
