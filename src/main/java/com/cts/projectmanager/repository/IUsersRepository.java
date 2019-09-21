package com.cts.projectmanager.repository;

import com.cts.projectmanager.eo.UsersEO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsersRepository extends JpaRepository<UsersEO, Integer> {
    UsersEO findUsersEOByUserId(int userId);
}
