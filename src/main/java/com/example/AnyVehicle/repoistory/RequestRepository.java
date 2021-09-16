package com.example.AnyVehicle.repoistory;

import com.example.AnyVehicle.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {

//    @Query("select * from requests r where r.u_id = ?1")
    List<Request> findAllByUser_id(long userId);

    @Query("select count(status) from requests where status = ?1")
    Integer getStatusNumber(String status);
}
