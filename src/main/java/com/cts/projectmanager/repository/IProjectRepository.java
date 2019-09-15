package com.cts.projectmanager.repository;

import com.cts.projectmanager.eo.ProjectEO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectRepository extends JpaRepository<ProjectEO,Long> {
}
