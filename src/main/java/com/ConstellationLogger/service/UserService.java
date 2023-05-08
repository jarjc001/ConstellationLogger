package com.ConstellationLogger.service;

import com.ConstellationLogger.dto.User;

public interface UserService {


    User getCurrentUser();

    /**
     * Gets the user info for a given username and password,
     * then sets the current user to the gotten user object.
     * If any input is empty or not the same as the database,
     * current user will be set to null
     * @param username username
     * @param password password
     */
    void loginUser(String username, String password);

    /**Logs current user out
     */
    void logUserOut();

    boolean checkLoggedIn();

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

    /**Update the user's info to the database, then set the current user's info
     * to the newly updated info. Only the email, firstname, lastname and premium can be changed.
     * @param email new email
     * @param userFirstName new first name
     * @param userLastName new last name
     * @param premium new premium status
     */
    void updateUserInfo (String email, String userFirstName, String userLastName, boolean premium);

    /**
     * Update the user's password to the database,
     * @param newPassword1 new password
     * @param newPassword2 new password retyped
     */
    void updateUserPassword(String newPassword1, String newPassword2);

    /**
     * First checks if the username and password are the same as current user,
     * Then removes the user's info from the database from its username and password
     * @param username username
     * @param password password
     */
    void removeUser(String username, String password);
}
