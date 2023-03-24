package com.ConstellationLogger.service;

public interface UserService {
    /**
     * Gets the user info for a given username and password,
     * then sets the current user to the gotten user object.
     * If any input is empty or not the same as the database,
     * current user will be set to null
     * @param username username
     * @param password password
     */
    void loginUser(String username, String password);

    /**Logs the current user out of the app
     */
    void logUserOut();

    /**
     *  Add a user to the database and then sets the current user into the new user.
     *  If any input is empty or the username is already in database,
     *  new user won't be added to database and current user will be set to null
     * @param username username
     * @param password password
     * @param email email
     * @param userFirstName userFirstName
     * @param userLastName userLastName
     * @param premium premium
     */
    void addUser(String username, String password, String email, String userFirstName, String userLastName, boolean premium);
}
