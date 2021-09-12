package com.example.AnyVehicle;

import com.example.AnyVehicle.model.UserApplication;
import com.example.AnyVehicle.repoistory.UserApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserApplicationRepository userApplicationRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserApplication user = userApplicationRepository.findByUsername(username);

        if(user == null){
            System.out.println("Error: user not found");
            throw new UsernameNotFoundException("user: " + username + " Not Found");
        }
        return user;
    }
}
