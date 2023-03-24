package com.ConstellationLogger.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class User {

    @NotBlank(message = "Username Incorrect")
    private String username;
    @NotBlank(message = "Password Incorrect")
    //@NotBlank(message = "Last name can not be empty")
    private String password;

    @NotNull(message = "Username Taken")
   // @NotBlank(message = "First name can not be empty")
    private String userFirstName;

    @NotNull(message = "All fields have to be filled in")
   // @NotBlank(message = "Last name can not be empty")
    private String userLastName;

    @Email
   // @NotBlank(message = "Email can not be empty")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return premium == user.premium && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(userFirstName, user.userFirstName) && Objects.equals(userLastName, user.userLastName) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, userFirstName, userLastName, email, premium);
    }
}
