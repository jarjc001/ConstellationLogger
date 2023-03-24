package com.ConstellationLogger.dao;

import com.ConstellationLogger.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoDB implements UserDao{

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public User getUserByLogin(String username, String password, User user) throws DataBaseException {
        User newUser = new User();

        //SQL query to get all Constellation with Abbr = abbr
        final String SELECT_USER_BY_USERNAME_AND_PASSWORD = "SELECT * FROM users WHERE (username= ? AND password= ?);";
        //returns Constellation objects
        try {
            newUser = jdbc.queryForObject(SELECT_USER_BY_USERNAME_AND_PASSWORD, new UserMapper(), username, password);
        }catch (DataAccessException e){ //will cause an error in html for incorrect password
            newUser.setUsername(user.getUsername());
            newUser.setPassword(null);
            newUser.setUserFirstName("password");
            newUser.setUserLastName("incorrect");
        }
        return newUser;
    }

    @Override
    public User addUser(User user) {

        //checks if user is taken

        final String INSERT_USER = "INSERT INTO  users"+
                "(username, password, userFirstName, userLastName, email, premium)" +
                " VALUES (?,?,?,?,?,?)";
        jdbc.update(INSERT_USER,
                user.getUsername(),
                user.getPassword(),
                user.getUserFirstName(),
                user.getUserLastName(),
                user.getEmail(),
                user.getPremium());

        return user;
    }

    @Override
    public boolean checkUsernameInDataBase(String username) {
        User user =new User();
        final String CHECK_USER_NAME = "SELECT * FROM users WHERE username = ?";
        try {
            user = jdbc.queryForObject(CHECK_USER_NAME, new UserMapper(), username);
        }catch (DataAccessException e){ //Username free

            return false;
        }
        return true;    //Username already Taken




    }

    @Override
    public void updateUser(User user) {
        final String UPDATE_USER = "UPDATE users SET password = ?, userFirstName = ?," +
                " userLastName = ?, email = ?, premium =? WHERE username = ?";
        jdbc.update(UPDATE_USER,
                user.getPassword(),
                user.getUserFirstName(),
                user.getUserLastName(),
                user.getEmail(),
                user.getPremium(),
                user.getUsername());
    }

    @Override
    @Transactional
    public void deleteUser(String username, String password) {
        //SQL query to delete from constellations log db
        final String DELETE_CONSTELLATION_LOG ="DELETE cl.* FROM constellationsLog cl " +
                "JOIN log l ON cl.logId = l.logId WHERE l.username = ?";
        jdbc.update(DELETE_CONSTELLATION_LOG, username);

        //SQL query to delete from log db
        final String DELETE_LOG ="DELETE FROM log WHERE username = ?";
        jdbc.update(DELETE_LOG, username);

        final String DELETE_USER = "DELETE FROM users WHERE (username = ? AND password = ?)";
        jdbc.update(DELETE_USER, username, password);
    }
}
