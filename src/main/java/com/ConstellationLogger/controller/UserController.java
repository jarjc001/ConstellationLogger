package com.ConstellationLogger.controller;

import com.ConstellationLogger.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import static com.ConstellationLogger.service.LogServiceImpl.logViolations;
import static com.ConstellationLogger.service.UserServiceImpl.userViolations;

@Controller
public class UserController {




    @Autowired
    UserService userService;


    @GetMapping("login")
    public String displayLogin(Model model){
        model.addAttribute("currentUser",userService.getCurrentUser());

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
    public String displayAccount(Model model){
        if(!userService.checkLoggedIn()){        //take them to login screen if they are not logged in
            return "redirect:/login";
        }

        model.addAttribute("errors", userViolations);

        model.addAttribute("currentUser", userService.getCurrentUser());
        return "account";
    }


    @PostMapping("editUserDetails")
    public String editUserDetails(HttpServletRequest request){
        String email = request.getParameter("newEmail");
        String userFirstName = request.getParameter("newFirstName");
        String userLastName = request.getParameter("newLastName");
        boolean premium;
        try {
            premium = Boolean.parseBoolean(request.getParameter("newPremium"));
        }catch(Exception e){
            premium = false;
        }
        userService.updateUserInfo(email,userFirstName,userLastName,premium);


        return "redirect:/account";
    }

    @PostMapping("editUserPassword")
    public String editUserPassword(HttpServletRequest request){
        String newPassword1 = request.getParameter("newPassword1");
        String newPassword2 = request.getParameter("newPassword2");


        userService.updateUserPassword(newPassword1,newPassword2);

        return "redirect:/account";
    }

    @GetMapping("deleteUser")
    public String displayDelete ( Model model){
        model.addAttribute("errors", userViolations);

        return "deleteUser";
    }

    @GetMapping("deleteUserAction")
    public String deleteUser(HttpServletRequest request){

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        userService.removeUser(username,password);

        if(!userViolations.isEmpty()) { //if there is an error in login check
            return "redirect:/deleteUser";
        }

        return "redirect:";
    }




}
