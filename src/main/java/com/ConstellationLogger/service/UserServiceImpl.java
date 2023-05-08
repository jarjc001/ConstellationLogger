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

    @Override
    public User getCurrentUser() {
        return currentUser;
    }

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
                newUser.setUserFirstName(" ");
                newUser.setUserFirstName(" ");
                newUser.setUserLastName(" ");
                throw new ServiceLayerException("Wrong Username");
            }


            newUser = userDao.getUserByLogin(username,password,newUser);



        } catch (Exception e) {     //if username or password wrong or empty
            currentUser = new User();
            System.out.println(e.getMessage());
            //show that password or username is wrong
        }

        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        userViolations = validate.validate(newUser);
        if(userViolations.isEmpty()) {
            currentUser = newUser;
        }
    }

    @Override
    public void logUserOut(){
        currentUser = new User();
    }

    @Override
    public boolean checkLoggedIn(){
        if(currentUser.getUsername().equals("")){   //no one is logged in
            return false;
        }else {                     //is logged in
            return true;
        }
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

        //if the username has already been taken
        if(userDao.checkUsernameInDataBase(newUser.getUsername())){
            newUser.setUserFirstName(null);
        }

        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        userViolations = validate.validate(newUser);

        if(userViolations.isEmpty()) {
            userDao.addUser(newUser);
            currentUser = newUser;
        }

    }

    @Override
    public void updateUserInfo(String email, String userFirstName, String userLastName, boolean premium) {
        userViolations.clear();
        User editedUser = new User();

        editedUser.setUsername(currentUser.getUsername());
        editedUser.setPassword(currentUser.getPassword());
        editedUser.setEmail(email);
        editedUser.setUserFirstName(userFirstName);
        editedUser.setUserLastName(userLastName);
        editedUser.setPremium(premium);
        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        userViolations = validate.validate(editedUser);

        if(userViolations.isEmpty()) {
            userDao.updateUser(editedUser);
            currentUser = editedUser;
        }

    }

    @Override
    public void updateUserPassword(String newPassword1, String newPassword2) {
        userViolations.clear();
        User editedUser = new User();

        //checks if new password is the same as old password
        if(currentUser.getPassword().equals(newPassword1)){
            return;
        }
        editedUser.setUsername(currentUser.getUsername());
        editedUser.setEmail(currentUser.getEmail());
        editedUser.setUserFirstName(currentUser.getUserFirstName());
        editedUser.setUserLastName(currentUser.getUserLastName());
        editedUser.setPremium(currentUser.getPremium());

        //checks if new password is same as retyped password
        if(newPassword1.equals(newPassword2)){
            editedUser.setPassword(newPassword1);
        }else{
            editedUser.setPassword(null);
        }

        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        userViolations = validate.validate(editedUser);

        if(userViolations.isEmpty()) {
            userDao.updateUser(editedUser);
            currentUser = editedUser;
        }


    }

    @Override
    public void removeUser(String username, String password) {

        userViolations.clear();
        User deleteUser = new User();
        try {
            if(!username.equals(currentUser.getUsername())){    //check username
                deleteUser.setUsername(null);
                deleteUser.setPassword("empty");
                deleteUser.setUserFirstName("empty ");
                deleteUser.setUserLastName("empty");
                throw new ServiceLayerException("Wrong Username");
            }
            if(!password.equals(currentUser.getPassword())){    //check password
                deleteUser.setUsername("empty");
                deleteUser.setPassword(null);
                deleteUser.setUserFirstName("empty");
                deleteUser.setUserLastName("empty");
                throw new ServiceLayerException("Wrong Password");
            }
            deleteUser = currentUser;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //show that password or username is wrong
        }

        Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        userViolations = validate.validate(deleteUser);
        if(userViolations.isEmpty()) {
            userDao.deleteUser(username,password);
            logUserOut();
        }

    }


}
