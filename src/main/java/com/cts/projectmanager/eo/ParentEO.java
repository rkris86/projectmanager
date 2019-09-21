package com.cts.projectmanager.eo;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "parent", schema = "project_test", catalog = "")
public class ParentEO {
    private long parentId;
    private String parentTask;
    private List<TaskEO> tasksByParentId;

    @Id
    @Column(name = "parent_id")
    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "parent_task")
    public String getParentTask() {
        return parentTask;
    }

    public void setParentTask(String parentTask) {
        this.parentTask = parentTask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParentEO parentEO = (ParentEO) o;
        return parentId == parentEO.parentId &&
                Objects.equals(parentTask, parentEO.parentTask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentId, parentTask);
    }

    @OneToMany(mappedBy = "parent")
    public List<TaskEO> getTasksByParentId() {
        return tasksByParentId;
    }

    public void setTasksByParentId(List<TaskEO> tasksByParentId) {
        this.tasksByParentId = tasksByParentId;
    }
}
