package com.ConstellationLogger.dao;

import com.ConstellationLogger.dto.User;

public interface UserDao {

    /**Get the user info from a given username and password.
     * Password has to be correct to get the user info
     * @param username username
     * @param password password
     * @return the user info object
     */
    User getUserByLogin(String username, String password);

    /**Add a new user to the database
     * @param user object with the info of new user
     * @return the user that has been added
     */
    User addUser(User user);

    /**Update info of a user
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
