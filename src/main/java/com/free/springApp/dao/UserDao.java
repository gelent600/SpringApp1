package com.free.springApp.dao;

import com.free.springApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
    User findUserByUserName(String username);
}
