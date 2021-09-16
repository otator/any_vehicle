package com.example.AnyVehicle.controller;

import com.example.AnyVehicle.model.Request;
import com.example.AnyVehicle.model.UserApplication;
import com.example.AnyVehicle.repoistory.RequestRepository;
import com.example.AnyVehicle.repoistory.UserApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import java.security.Principal;
import java.util.List;

@Controller
public class RequestController {

    @Autowired
    UserApplicationRepository userApplicationRepository;

    @Autowired
    RequestRepository requestRepository;

    @PostMapping("/send_request")
    public RedirectView addRequest(String manufacturer, String model, String carNumber, String type, String description,
                                   Principal principal, Model m){

        UserApplication user = userApplicationRepository.findByUsername(principal.getName());
        Request request = new Request(manufacturer, model, carNumber, type, user, description);
        requestRepository.save(request);
        List<Request> requests= requestRepository.findAllByUser_id(user.getUserId());
        for(Request r: requests){
            System.out.println(r);

        }
        m.addAttribute("requests", requests);
        System.out.println(request.getStatus()+ " user is" + user.getFirstName());
        return new RedirectView("/myrequests");
    }

    @GetMapping("/myrequests")
    public String showCurrentUserRequests(Principal principal, Model model){
        UserApplication user = userApplicationRepository.findByUsername(principal.getName());
        List<Request> requests= requestRepository.findAllByUser_id(user.getUserId());
        model.addAttribute("requests", requests);
        return "user_request.html";

    }


}
