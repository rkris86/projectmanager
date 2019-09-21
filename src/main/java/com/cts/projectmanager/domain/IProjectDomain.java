package com.cts.projectmanager.domain;

import com.cts.projectmanager.dto.ProjectDTO;
import com.cts.projectmanager.dto.ProjectResponseDTO;

import java.util.List;

/**
 * Domain Class for Project Screen
 * @author Ramakrishna Gurram
 */
public interface IProjectDomain {
    /**
     * Method to fetch List of projects
     * @return
     */
    List<ProjectResponseDTO> fetchProjects();

    /**
     *  Method to add Project to the database
     * @param project
     * @return
     */
    List<ProjectResponseDTO> addProject(ProjectDTO project);

    /**
     * Delete a project from Database.
     * @param projectDTO
     * @return
     */
    List<ProjectResponseDTO> deleteProject(ProjectDTO projectDTO);
}
