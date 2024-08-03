package com.gokapture.taskmanagement.taskmanagement_service.repositories;


import com.gokapture.taskmanagement.taskmanagement_service.models.JwtRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtRequestRepository extends JpaRepository<JwtRequest, Long> {
    // Define custom query methods if needed
}
