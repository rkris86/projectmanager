package com.cts.projectmanager.repository;

import com.cts.projectmanager.eo.TaskEO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<TaskEO,Long> {
}
