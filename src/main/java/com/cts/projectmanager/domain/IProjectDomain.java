package com.cts.projectmanager.domain;

import com.cts.projectmanager.dto.ProjectDTO;

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
    List<ProjectDTO> fetchProjects();

    /**
     *  Method to add Project to the database
     * @param project
     * @return
     */
    List<ProjectDTO> addProject(ProjectDTO project);

    /**
     * Delete a project from Database.
     * @param projectDTO
     * @return
     */
    List<ProjectDTO> deleteProject(ProjectDTO projectDTO);
}
