package com.cts.projectmanager.service;

import com.cts.projectmanager.dto.ProjectDTO;
import com.cts.projectmanager.dto.ProjectResponseDTO;

import java.util.List;

public interface IProjectService {
    /**
     * Method to fetch Projects
     * @return
     */
    List<ProjectResponseDTO> fetchProject();

    /**
     * Method to add Project
     * @param project
     * @return
     */
    List<ProjectResponseDTO> addProject(ProjectDTO project);

    /**
     * Method to delete Project
     * @param project
     * @return
     */
    List<ProjectResponseDTO> deleteProject(ProjectDTO project);
}
