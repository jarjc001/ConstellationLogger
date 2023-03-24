package com.ConstellationLogger.service;

import com.ConstellationLogger.dao.DataBaseException;
import com.ConstellationLogger.dao.UserDao;
import com.ConstellationLogger.dto.User;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    /**Current user logged in to site */
    protected static User currentUser = new User();

    @Autowired
    UserDao userDao;

    public static Set<ConstraintViolation<User>> userViolations = new HashSet<>();

    @Override
    public void loginUser(String username, String password){
        userViolations.clear();
        User newUser = new User();
        try {
            newUser.setUsername(username);

            if(!userDao.checkUsernameInDataBase(username)){//checks if the username is correct
                newUser.setUsername(null);
                newUser.setPassword("Username");
                newUser.setUserLastName("not");
                newUser.setUserFirstName("correct");
            }


            newUser = userDao.getUserByLogin(username,password,newUser);

            Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
            userViolations = validate.validate(newUser);
            if(!userViolations.isEmpty()) {
                currentUser = newUser;
            }

        } catch (DataBaseException e) {     //if username or password wrong or empty
            currentUser = new User();
            System.out.println(e.getMessage());
            //show that password or username is wrong
        }
    }

    @Override
    public void logUserOut(){
        currentUser = new User();
    }


    @Override
    public void addUser(String username, String password, String email, String userFirstName, String userLastName, boolean premium){
        userViolations.clear();
        User newUser = new User();

        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setUserFirstName(userFirstName);
        newUser.setUserLastName(userLastName);
        newUser.setPremium(premium);

        //if any fields are empty, validate will flag it up and sent an error "All fields have to be filled in"
        if(username.equals("") | password.equals("") | email.equals("") | userFirstName.equals("") | userLastName.equals("")){
            newUser.setUsername("failed");
            newUser.setPassword("input");
            newUser.setUserFirstName("empty");
            newUser.setUserLastName(null);
        }

        //if the username has already been taken
        if(userDao.checkUsernameInDataBase(newUser.getUsername())){
            newUser.setUsername("Username");
            newUser.setPassword("already");
            newUser.setUserLastName("taken");
            newUser.setUserFirstName(null);
        }

        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        userViolations = validate.validate(newUser);



        if(userViolations.isEmpty()) {
            userDao.addUser(newUser);
            currentUser = newUser;
        }else {
            currentUser = new User();
        }


    }




}
