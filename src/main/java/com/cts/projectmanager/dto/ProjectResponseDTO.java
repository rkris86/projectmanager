package com.cts.projectmanager.dto;

public class ProjectResponseDTO extends ProjectDTO {
    private int taskNumbers;
    private int taskCompleted;
    private String managerName;

    public int getTaskNumbers() {
        return taskNumbers;
    }

    public void setTaskNumbers(int taskNumbers) {
        this.taskNumbers = taskNumbers;
    }

    public int getTaskCompleted() {
        return taskCompleted;
    }

    public void setTaskCompleted(int taskCompleted) {
        this.taskCompleted = taskCompleted;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}
