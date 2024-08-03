package com.gokapture.taskmanagement.taskmanagement_service.services;


import com.gokapture.taskmanagement.taskmanagement_service.models.JwtRequest;
import com.gokapture.taskmanagement.taskmanagement_service.models.JwtResponse;
import com.gokapture.taskmanagement.taskmanagement_service.repositories.JwtRequestRepository;
import com.gokapture.taskmanagement.taskmanagement_service.repositories.JwtResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtService {


    private final JwtResponseRepository jwtResponseRepository;

    @Autowired
    public JwtService( JwtResponseRepository jwtResponseRepository) {

        this.jwtResponseRepository = jwtResponseRepository;
    }


    public void saveJwtResponse(String username, String token) {
        JwtResponse jwtResponse = JwtResponse.builder()
                .username(username)
                .jwtToken(token)
                .build();
        jwtResponseRepository.save(jwtResponse);
    }
}
