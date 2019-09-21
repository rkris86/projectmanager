package com.cts.projectmanager.eo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "project_test", catalog = "")
public class UsersEO {
    private int userId;
    private String firstName;
    private String lastName;
    private int employeeId;
    private ProjectEO project;
    private TaskEO task;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "employee_id")
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEO usersEO = (UsersEO) o;
        return userId == usersEO.userId &&
                employeeId == usersEO.employeeId &&
                Objects.equals(firstName, usersEO.firstName) &&
                Objects.equals(lastName, usersEO.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, employeeId);
    }

    @OneToOne
    @JoinColumn(name = "project_id")
    public ProjectEO getProject() {
        return project;
    }

    public void setProject(ProjectEO project) {
        this.project = project;
    }


    @OneToOne
    @JoinColumn(name = "task_id")
    public TaskEO getTask() {
        return task;
    }

    public void setTask(TaskEO task) {
        this.task = task;
    }
}
