package com.ConstellationLogger.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class User {

    @NotBlank(message = "Username Incorrect")

    private String username;
    @NotBlank(message = "Password Incorrect")
    private String password;

    @NotNull(message = "Username Taken")
    private String userFirstName;

    @NotNull(message = "All fields have to be filled in")
    private String userLastName;

    private String email;
    private boolean premium;


    public User(String username, String password, String userFirstName, String userLastName, String email, boolean premium) {
        this.username = username;
        this.password = password;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.email = email;
        this.premium = premium;
    }

    public User() {
        this.username = "";
        this.password = "";
    }

    //getters
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getUserFirstName() {
        return userFirstName;
    }
    public String getUserLastName() {
        return userLastName;
    }
    public String getEmail() {
        return email;
    }

    public boolean getPremium() {
        return premium;
    }


    //setters
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }
    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPremium(boolean premium) {
        this.premium = premium;
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", email='" + email + '\'' +
                ", premium=" + premium +
                '}';
    }
}
