package com.gokapture.taskmanagement.taskmanagement_service.repositories;

import com.gokapture.taskmanagement.taskmanagement_service.models.JwtResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtResponseRepository extends JpaRepository<JwtResponse, Long> {
    // Define custom query methods if needed
}
