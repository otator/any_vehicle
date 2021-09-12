package com.example.AnyVehicle.controller;

import com.example.AnyVehicle.model.Request;
import com.example.AnyVehicle.repoistory.RequestRepository;
import com.example.AnyVehicle.repoistory.UserApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    UserApplicationRepository userApplicationRepository;

    @Autowired
    RequestRepository requestRepository;

    @GetMapping("/requests")
    public String showAllRequests(Model model){
        List<Request> requests = requestRepository.findAll();
        model.addAttribute("requests", requests);
        return "requests.html";
    }

    @PostMapping("/accept/{id}")
    public RedirectView acceptRequest(@PathVariable(value="id") long id){
        System.out.println("Accepted");
        Request request = requestRepository.findById(id).get();
        request.setStatus("accepted");
        requestRepository.save(request);
        return new RedirectView("/requests");
    }

    @PostMapping("/dismiss/{id}")
    public RedirectView dismissRequest(@PathVariable(value="id") long id){
        System.out.println("Dismissed");
        Request request = requestRepository.findById(id).get();
        request.setStatus("dismissed");
        requestRepository.save(request);
        return new RedirectView("/requests");
    }


}
