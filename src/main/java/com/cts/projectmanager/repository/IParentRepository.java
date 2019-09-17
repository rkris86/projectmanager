package com.cts.projectmanager.repository;

import com.cts.projectmanager.eo.ParentEO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IParentRepository extends JpaRepository<ParentEO,Long> {

}
