package com.ConstellationLogger.dao;

import com.ConstellationLogger.dto.User;

public interface UserDao {

    /**Get the user info from a given username and password.
     * Password has to be correct to get the user info
     * @param username username
     * @param password password
     * @param user the user info object
     */
    User getUserByLogin(String username, String password, User user) throws DataBaseException;

    /**Add a new user to the database if the username is unique
     * @param user object with the info of new user
     * @return the user that has been added
     */
    User addUser(User user) ;

    /**
     * Checks if the username has been taken in db
     * @param username username
     * @return true id username is already there, false if it is free to take
     */
    public boolean checkUsernameInDataBase(String username);

    /**Update info of a user in database
     * @param user user object with the edited info
     */
    void updateUser(User user);

    /**delete user from database,
     * have to have username and password
     * @param username username
     * @param password password
     */
    void deleteUser(String username, String password);




}
