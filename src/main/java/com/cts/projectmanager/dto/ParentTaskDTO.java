package com.cts.projectmanager.dto;

import java.io.Serializable;

/**
 * Parent Task DTO
 *
 * @author Ramakrishna Gurram
 */
public class ParentTaskDTO implements Serializable {
    private Long parentId;
    private String parentTask;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentTask() {
        return parentTask;
    }

    public void setParentTask(String parentTask) {
        this.parentTask = parentTask;
    }

    public ParentTaskDTO(Long parentId, String parentTask) {
        this.parentId = parentId;
        this.parentTask = parentTask;
    }
}
