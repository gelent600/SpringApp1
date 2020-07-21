package com.free.springApp.service;

public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String username,String password);
}
