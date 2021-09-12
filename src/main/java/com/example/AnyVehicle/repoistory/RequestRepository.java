package com.example.AnyVehicle.repoistory;

import com.example.AnyVehicle.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {


    List<Request> findAllByUser(Long userId);
}
