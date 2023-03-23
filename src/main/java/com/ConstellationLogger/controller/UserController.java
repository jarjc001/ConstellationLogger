package com.ConstellationLogger.controller;

import com.ConstellationLogger.dao.ConstellationDao;
import com.ConstellationLogger.dao.LogDao;
import com.ConstellationLogger.dao.UserDao;
import com.ConstellationLogger.dto.User;
import com.ConstellationLogger.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;

@Controller
public class UserController {

    @Autowired
    UserService userService;



    @Autowired
    ConstellationDao conDao;

    @Autowired
    LogDao logDao;

    @Autowired
    UserDao userDao;

    @GetMapping("login")
    public String displayLogin(){
        return "login";
    }


    @GetMapping("loginUser")
    public String loginUser(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        userService.loginUser(username,password);

        return "redirect:";
    }

    @PostMapping("createUser")
    public String createUser(HttpServletRequest request){
        String username = request.getParameter("addedUsername");
        String password = request.getParameter("addedPassword");
        String email = request.getParameter("addedEmail");
        String userFirstName = request.getParameter("addedFirstName");
        String userLastName = request.getParameter("addedLastName");
        boolean premium;
        try {
            premium = Boolean.parseBoolean(request.getParameter("addedPremium"));
        }catch(Exception e){
            premium = false;
        }

        userService.addUser(username,password,email,userFirstName,userLastName,premium);

        return "redirect:";
    }


    @GetMapping("account")
    public String displayAccount(){
        ///make sure current acount doesnt crash it if it is null
        return "account";
    }


    @PostMapping("editUser")
    public String editUser(HttpServletRequest request, Model model){
        return "redirect:/account";
    }




}
