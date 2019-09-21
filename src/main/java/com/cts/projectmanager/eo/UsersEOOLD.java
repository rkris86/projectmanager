package com.cts.projectmanager.eo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "project")
public class UsersEOOLD implements Serializable {
    private int userId;
    private String firstName;
    private String lastName;
    private int employeeId;
    private Long projectId;
    private Long taskId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "employee_id")
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Column(name = "project_id")
    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    @Column(name = "task_id")
    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsersEOOLD)) return false;
        UsersEOOLD usersEO = (UsersEOOLD) o;
        return getUserId() == usersEO.getUserId() &&
                getEmployeeId() == usersEO.getEmployeeId() &&
                getFirstName().equals(usersEO.getFirstName()) &&
                getLastName().equals(usersEO.getLastName()) &&
                Objects.equals(getProjectId(), usersEO.getProjectId()) &&
                Objects.equals(getTaskId(), usersEO.getTaskId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getFirstName(), getLastName(), getEmployeeId(), getProjectId(), getTaskId());
    }
}
