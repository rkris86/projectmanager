package com.cts.projectmanager.repository;

import com.cts.projectmanager.eo.ProjectEO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface IProjectRepository extends JpaRepository<ProjectEO,Long> {

    ProjectEO findProjectEOByProjectId(Long projectId);
    @Transactional
    void deleteProjectEOByProjectId(Long projectId);
}
