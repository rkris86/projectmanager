package com.cts.projectmanager.domain;

import com.cts.projectmanager.dto.ProjectDTO;
import com.cts.projectmanager.eo.ProjectEO;
import com.cts.projectmanager.repository.IProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Component
public class ProjectDomainImpl implements IProjectDomain {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectDomainImpl.class);
    private IProjectRepository projectRepository;

    @Autowired
    public ProjectDomainImpl(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    /**
     * Method to fetch List of projects
     *
     * @return
     */
    @Override
    public List<ProjectDTO> fetchProjects() {
        LOGGER.debug(" fetchProjects() method started");
        List<ProjectEO> projectsEos = projectRepository.findAll();
        List<ProjectDTO> response = mapProjects(projectsEos);
        LOGGER.debug(" fetchProjects() method ended");
        return response;
    }

    private List<ProjectDTO> mapProjects(List<ProjectEO> projectsEos) {
        LOGGER.debug("mapProjects() method started");
        List<ProjectDTO> projectDTOS = new ArrayList<>();
        for (ProjectEO project : projectsEos) {
            ProjectDTO projectDTO = new ProjectDTO();
            projectDTO.setProjectId(project.getProjectId());
            projectDTO.setProject(project.getProject());
            projectDTO.setStartDate(project.getStartDate() != null ? project.getStartDate().toString() : "");
            projectDTO.setEndDate(project.getEndDate() != null ? project.getEndDate().toString() : "");
            projectDTO.setPriority(project.getPriority());
            projectDTOS.add(projectDTO);
        }
        LOGGER.debug("mapProjects() method ended");
        return projectDTOS;
    }

    /**
     * Method to add Project to the database
     *
     * @param project
     * @return
     */
    @Override
    public List<ProjectDTO> addProject(ProjectDTO project) {
        LOGGER.debug("addProject() method started");
        ProjectEO projectEO = new ProjectEO();
        projectEO.setProject(project.getProject());
        projectEO.setPriority(project.getPriority());
        if (null != project.getStartDate()) {
            projectEO.setStartDate(Date.valueOf(project.getStartDate()));
        }
        if (null != project.getEndDate()) {
            projectEO.setEndDate(Date.valueOf(project.getEndDate()));
        }
        if (null != project.getProjectId()) {
            projectEO.setProjectId(project.getProjectId());
        }
        projectRepository.saveAndFlush(projectEO);

        LOGGER.debug("addProject() method ended");
        return fetchProjects();
    }

    /**
     * Delete a project from Database.
     *
     * @param project
     * @return
     */
    @Override
    public List<ProjectDTO> deleteProject(ProjectDTO project) {
        LOGGER.debug("deleteProject() method started");
        ProjectEO projectEO = new ProjectEO();
        projectEO.setProject(project.getProject());
        projectEO.setPriority(project.getPriority());
        if (null != project.getStartDate()) {
            projectEO.setStartDate(Date.valueOf(project.getStartDate()));
        }
        if (null != project.getEndDate()) {
            projectEO.setEndDate(Date.valueOf(project.getEndDate()));
        }
        if (project.getProjectId() > 0) {
            projectEO.setProjectId(project.getProjectId());
        }
        projectRepository.delete(projectEO);
        LOGGER.debug("deleteProject() method ended");
        return fetchProjects();
    }
}
