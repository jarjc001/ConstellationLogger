package com.ConstellationLogger.service;

public interface UserService {
    void loginUser(String username, String password);


    void addUser(String username, String password, String email, String userFirstName, String userLastName, boolean premium);
}
