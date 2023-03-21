package com.ConstellationLogger.dao;

import com.ConstellationLogger.dto.User;

public interface UserDao {

    /**Get the user info from a given username and password.
     * Password has to be correct to get the user info
     * @param username username
     * @param password password
     * @return the user info object
     */
    User getUserByLogin(String username, String password) throws DataBaseException;

    /**Add a new user to the database if the username is unique
     * @param user object with the info of new user
     * @return the user that has been added
     */
    User addUser(User user) throws DataBaseException;

    /**Checks if the username has been taken in db
     * @param username username
     * @throws DataBaseException will return exception if the username is already in db
     */
    public void checkUsernameInDataBase(String username) throws DataBaseException;

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
