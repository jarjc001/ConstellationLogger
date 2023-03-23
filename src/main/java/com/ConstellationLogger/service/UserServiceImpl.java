package com.ConstellationLogger.service;

import com.ConstellationLogger.dao.ConstellationDao;
import com.ConstellationLogger.dao.DataBaseException;
import com.ConstellationLogger.dao.LogDao;
import com.ConstellationLogger.dao.UserDao;
import com.ConstellationLogger.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{

    /**Current user logged in to site */
    protected static User currentUser = new User();

    @Autowired
    ConstellationDao conDao;

    @Autowired
    LogDao logDao;

    @Autowired
    UserDao userDao;

    @Override
    public void loginUser(String username, String password){
        try {

            if(username.equals("")){
                username =null;
            } else if (password.equals("")) {
                password =null;
            }

            currentUser = userDao.getUserByLogin(username,password);
        } catch (DataBaseException e) {     //if username or password wrong or empty
            currentUser = new User();
            System.out.println(e.getMessage());
            //show that password or username is wrong
        }
    }


    @Override
    public void addUser(String username, String password, String email, String userFirstName, String userLastName, boolean premium){
        User newUser = new User();



        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setUserFirstName(userFirstName);
        newUser.setUserLastName(userLastName);
        newUser.setPremium(premium);

        if(username.equals("") | password.equals("") | email.equals("") | userFirstName.equals("") | userLastName.equals("")){
            newUser = null;
        }

        try {
            userDao.addUser(newUser);
            currentUser = newUser;
        } catch (DataBaseException e) {     //if any fields are empty or username is taken
            currentUser = new User();
            System.out.println(e.getMessage());
        }

    }




}
