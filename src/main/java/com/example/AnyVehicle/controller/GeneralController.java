package com.example.AnyVehicle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController{

    // show the main page for the user
    @GetMapping("/")
    public String showHomePage(){
        return "home.html";
    }
    // test route
    // TODO: remove this method once you're done.
    @GetMapping("/test")
    public String getTest(){
        return "test.html" ;
    }
    // show login form for the user to login to the website
    @GetMapping("/login")
    public String showLoginForm(){
        return "log_in.html";
    }

    // show the sign up for the user to register new account.
    @GetMapping("/signup")
    public String showSignupForm(){
        return "sign_up.html";
    }

    //show requests pages
    @GetMapping("/requests")
    public String showRequestsPage(){
        return "requests.html";
    }
}
