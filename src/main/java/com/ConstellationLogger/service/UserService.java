package com.ConstellationLogger.service;

public interface UserService {
    /**
     * Gets the user info for a given username and password,
     * then sets the current user to the gotten user object
     * @param username username
     * @param password password
     */
    void loginUser(String username, String password);

    /**
     *  Add a user to the database and then sets the current user into the new user
     * @param username username
     * @param password password
     * @param email email
     * @param userFirstName userFirstName
     * @param userLastName userLastName
     * @param premium premium
     */
    void addUser(String username, String password, String email, String userFirstName, String userLastName, boolean premium);
}
