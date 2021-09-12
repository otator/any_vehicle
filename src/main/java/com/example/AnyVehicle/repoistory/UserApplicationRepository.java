package com.example.AnyVehicle.repoistory;

import com.example.AnyVehicle.model.UserApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserApplicationRepository extends JpaRepository<UserApplication, Long> {

    UserApplication findByUsername(String username);

}
