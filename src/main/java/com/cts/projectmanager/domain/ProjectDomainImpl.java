package com.cts.projectmanager.domain;

import com.cts.projectmanager.dto.ProjectDTO;
import com.cts.projectmanager.dto.ProjectResponseDTO;
import com.cts.projectmanager.dto.TaskDTO;
import com.cts.projectmanager.dto.UserDTO;
import com.cts.projectmanager.eo.ProjectEO;
import com.cts.projectmanager.eo.TaskEO;
import com.cts.projectmanager.eo.UsersEO;
import com.cts.projectmanager.repository.IProjectRepository;
import com.cts.projectmanager.repository.IUsersRepository;
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
    private IUsersRepository usersRepository;

    @Autowired
    public ProjectDomainImpl(IProjectRepository projectRepository, IUsersRepository usersRepository) {
        this.projectRepository = projectRepository;
        this.usersRepository = usersRepository;
    }

    /**
     * Method to fetch List of projects
     *
     * @return
     */
    @Override
    public List<ProjectResponseDTO> fetchProjects() {
        LOGGER.debug(" fetchProjects() method started");
        List<ProjectEO> projectsEos = projectRepository.findAll();
        List<ProjectResponseDTO> response = mapProjects(projectsEos);
        LOGGER.debug(" fetchProjects() method ended");
        return response;
    }

    private List<ProjectResponseDTO> mapProjects(List<ProjectEO> projectsEos) {
        LOGGER.debug("mapProjects() method started");
        List<ProjectResponseDTO> projectDTOS = new ArrayList<>();
        for (ProjectEO project : projectsEos) {
            ProjectResponseDTO projectDTO = new ProjectResponseDTO();
            projectDTO.setProjectId(project.getProjectId());
            projectDTO.setProject(project.getProject());
            projectDTO.setStartDate(project.getStartDate() != null ? project.getStartDate().toString() : "");
            projectDTO.setEndDate(project.getEndDate() != null ? project.getEndDate().toString() : "");
            projectDTO.setPriority(project.getPriority());
            if (null != project.getUser()) {
                projectDTO.setUser(project.getUser().getUserId());
                projectDTO.setManagerName(project.getUser().getFirstName()+ " "+ project.getUser().getLastName());
            }
            if (null!= project.getTasks()) {
                int taskNumber = project.getTasks().size();
                int completed = 0;
                List<TaskDTO> tasks = new ArrayList<>();
                for(TaskEO taskEO : project.getTasks()){
                    if(null !=taskEO.getStatus()) {
                        if (taskEO.getStatus().equalsIgnoreCase("completed")) {
                            completed = completed + 1;
                        }
                    }
                }
                projectDTO.setTaskNumbers(taskNumber);
                projectDTO.setTaskCompleted(completed);
            }
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
    public List<ProjectResponseDTO> addProject(ProjectDTO project) {
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
            ProjectEO existingProjectEO = projectRepository.findProjectEOByProjectId(project.getProjectId());
            if(!projectEO.equals(existingProjectEO)) {
                 projectEO = projectRepository.saveAndFlush(projectEO);
            }
                UsersEO existingUserEO = existingProjectEO.getUser();
                UsersEO usersEO = new UsersEO();
                if(null == existingUserEO ){
                    usersEO = usersRepository.findUsersEOByUserId(project.getUser());
                    usersEO.setProject(existingProjectEO);
                    usersRepository.saveAndFlush(usersEO);
                }else if(!existingUserEO.equals(usersEO)){
                    existingUserEO.setProject(null);
                    usersRepository.saveAndFlush(existingUserEO);
                    usersEO.setProject(projectEO);
                    usersRepository.saveAndFlush(usersEO);
                }
        } else {
            // New Project
            UsersEO usersEO = new UsersEO();
            usersEO = usersRepository.findUsersEOByUserId(project.getUser());
            ProjectEO projectResponse = projectRepository.saveAndFlush(projectEO);
            usersEO.setProject(projectResponse);
            usersRepository.saveAndFlush(usersEO);
        }

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
    public List<ProjectResponseDTO> deleteProject(ProjectDTO project) {
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
