package com.free.springApp.service;

import com.free.springApp.model.User;

public interface UserService {
    void save(User user);
    User findUserByUserName(String username);
}
