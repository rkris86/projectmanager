package com.cts.projectmanager.eo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "task", schema = "project_test", catalog = "")
public class TaskEO {
    private long taskId;
    private String task;
    private Date startDate;
    private Date endDate;
    private String status;
    private Integer priority;
    private ParentEO parent;
    private ProjectEO project;
    private UsersEO user;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    @Basic
    @Column(name = "task")
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Basic
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "priority")
    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskEO taskEO = (TaskEO) o;
        return taskId == taskEO.taskId &&
                Objects.equals(task, taskEO.task) &&
                Objects.equals(startDate, taskEO.startDate) &&
                Objects.equals(endDate, taskEO.endDate) &&
                Objects.equals(status, taskEO.status) &&
                Objects.equals(priority, taskEO.priority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, task, startDate, endDate, status, priority);
    }

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "parent_id")
    public ParentEO getParent() {
        return parent;
    }

    public void setParent(ParentEO parentByParentId) {
        this.parent = parentByParentId;
    }
    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    public ProjectEO getProject() {
        return project;
    }

    public void setProject(ProjectEO project) {
        this.project = project;
    }

    @OneToOne(mappedBy = "task")
    public UsersEO getUser() {
        return user;
    }

    public void setUser(UsersEO user) {
        this.user = user;
    }
}
