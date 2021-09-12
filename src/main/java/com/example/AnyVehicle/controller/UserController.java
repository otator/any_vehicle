package com.example.AnyVehicle.controller;

import com.example.AnyVehicle.model.UserApplication;
import com.example.AnyVehicle.repoistory.UserApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @Autowired
    UserApplicationRepository userApplicationRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/signup")
    public RedirectView login(String firstName, String lastName, String username, String phone, String password){

        UserApplication newUser = new UserApplication(firstName, lastName, username, phone,
                bCryptPasswordEncoder.encode(password), "USER");
        userApplicationRepository.save(newUser);
        return new RedirectView("/login");
    }

}
