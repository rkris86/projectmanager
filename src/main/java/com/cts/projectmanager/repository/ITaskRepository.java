package com.cts.projectmanager.repository;

import com.cts.projectmanager.eo.ProjectEO;
import com.cts.projectmanager.eo.TaskEO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ITaskRepository extends JpaRepository<TaskEO,Long> {
    @Query("select m from TaskEO m where projectId= ?1")
    List<TaskEO> findTaskEOSByProjectId(Long ProjectId);

    TaskEO findTaskEOSByTaskId(Long taskId);
    @Transactional
    void deleteTaskEOByTaskId(Long taskId);
}
