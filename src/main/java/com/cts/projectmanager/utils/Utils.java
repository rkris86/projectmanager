package com.cts.projectmanager.utils;

import com.cts.projectmanager.dto.ParentTaskDTO;
import com.cts.projectmanager.dto.ProjectDTO;
import com.cts.projectmanager.dto.TaskDTO;
import com.cts.projectmanager.dto.UserDTO;
import com.cts.projectmanager.eo.ParentEO;
import com.cts.projectmanager.eo.ProjectEO;
import com.cts.projectmanager.eo.TaskEO;
import com.cts.projectmanager.eo.UsersEO;

import java.sql.Date;

public class Utils {
    public static ProjectEO createProjectEO(ProjectDTO project) {
        ProjectEO projectEO = new ProjectEO();
        projectEO.setPriority(project.getPriority());
        projectEO.setProject(project.getProject());
        if(project.getStartDate() != null && !project.getStartDate().isEmpty()) {
            projectEO.setStartDate(project.getStartDate() != null ? Date.valueOf(project.getStartDate()) : null);
        }
        if(project.getEndDate() != null && !project.getEndDate().isEmpty()) {
            projectEO.setEndDate(project.getEndDate() != null ? Date.valueOf(project.getEndDate()) : null);
        }
        projectEO.setProjectId(project.getProjectId());
        return projectEO;
    }

    public static UsersEO createUserEO(UserDTO user) {
        UsersEO usersEO = new UsersEO();
        usersEO.setEmployeeId(user.getEmployeeId());
        usersEO.setLastName(user.getLastName());
        usersEO.setFirstName(user.getFirstName());
        usersEO.setUserId(user.getUserId());
        return usersEO;
    }

    public static TaskEO createTaskEO(TaskDTO task) {
        TaskEO taskEO = new TaskEO();
        if (null != task.getTaskId()) {
            taskEO.setTaskId(task.getTaskId());
        }
        taskEO.setTask(task.getTask());
        taskEO.setStatus(task.getStatus());
        taskEO.setEndDate(task.getEndDate() != null ? Date.valueOf(task.getEndDate()) : null);
        taskEO.setStartDate(task.getStartDate() != null ? Date.valueOf(task.getStartDate()) : null);
        taskEO.setPriority(task.getPriority());
        if (null != task.getParentTask()) {
            taskEO.setParent(createParentEO(task.getParentTask()));
        }
        if (null != task.getProject()) {
            taskEO.setProject(createProjectEO(task.getProject()));
        }
        return taskEO;
    }

    public static ParentEO createParentEO(ParentTaskDTO parent) {
        ParentEO parentEO = new ParentEO();
        parentEO.setParentTask(parentEO.getParentTask());
        parentEO.setParentId(parent.getParentId());
        return parentEO;
    }


}
