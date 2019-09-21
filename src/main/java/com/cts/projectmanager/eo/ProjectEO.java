package com.cts.projectmanager.eo;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "project", schema = "project_test", catalog = "")
public class ProjectEO {
    private long projectId;
    private String project;
    private Date startDate;
    private Date endDate;
    private int priority;
    private UsersEO user;
    private List<TaskEO> tasks;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id")
    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "project")
    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
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
    @Column(name = "priority")
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectEO projectEO = (ProjectEO) o;
        return projectId == projectEO.projectId &&
                priority == projectEO.priority &&
                Objects.equals(project, projectEO.project) &&
                Objects.equals(startDate, projectEO.startDate) &&
                Objects.equals(endDate, projectEO.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, project, startDate, endDate, priority);
    }

    @OneToOne(mappedBy = "project")
    public UsersEO getUser() {
        return user;
    }

    public void setUser(UsersEO user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "project")
    public List<TaskEO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskEO> tasks) {
        this.tasks = tasks;
    }
}
