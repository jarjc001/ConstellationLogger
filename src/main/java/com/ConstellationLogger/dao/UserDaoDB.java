package com.ConstellationLogger.dao;

import com.ConstellationLogger.dto.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoDB implements UserDao{
    @Override
    public User getUserByLogin(String username, String password) {
        return null;
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(String username, String password) {

    }
}
