package com.cts.projectmanager.dto;

import java.io.Serializable;

/**
 * Task DTO class
 *
 * @author Ramakrishna Gurram
 */
public class TaskDTO implements Serializable {
    private Long taskId;
    private ParentTaskDTO parentTask;
    private ProjectDTO project;
    private String task;
    private String startDate;
    private String endDate;
    private String status;
    private int priority;
    private UserDTO user;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public ParentTaskDTO getParentTask() {
        return parentTask;
    }

    public void setParentTask(ParentTaskDTO parentTask) {
        this.parentTask = parentTask;
    }

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
