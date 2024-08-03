package com.gokapture.taskmanagement.taskmanagement_service.controllers;

import com.gokapture.taskmanagement.taskmanagement_service.models.JwtRequest;
import com.gokapture.taskmanagement.taskmanagement_service.models.JwtResponse;
import com.gokapture.taskmanagement.taskmanagement_service.models.User;
import com.gokapture.taskmanagement.taskmanagement_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            userService.signup(user);
            return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest jwtRequest) {
        try {
            // Call login method from UserService
            String token = userService.login(jwtRequest.getUsername(), jwtRequest.getPassword());

            return ResponseEntity.ok(new JwtResponse(null, jwtRequest.getUsername(), token));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
