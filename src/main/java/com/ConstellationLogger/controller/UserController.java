package com.ConstellationLogger.controller;

import com.ConstellationLogger.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import static com.ConstellationLogger.service.UserServiceImpl.userViolations;

@Controller
public class UserController {




    @Autowired
    UserService userService;


    @GetMapping("login")
    public String displayLogin(Model model){

        model.addAttribute("errors", userViolations);

        return "login";
    }

    @GetMapping("logout")
    public String logout(){
        userService.logUserOut();
        return "redirect:/";
    }


    @GetMapping("loginUser")
    public String loginUser(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        userService.loginUser(username,password);

        if(!userViolations.isEmpty()) {
            return "redirect:/login";
        }
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

        if(!userViolations.isEmpty()) {
            return "redirect:/login";
        }
        return "redirect:";


    }


    @GetMapping("account")
    public String displayAccount(){
        return "account";
    }


    @PostMapping("editUser")
    public String editUser(HttpServletRequest request, Model model){
        return "redirect:/account";
    }




}
