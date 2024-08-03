package com.gokapture.taskmanagement.taskmanagement_service.services;

import com.gokapture.taskmanagement.taskmanagement_service.models.User;
import com.gokapture.taskmanagement.taskmanagement_service.repositories.UserRepository;
import com.gokapture.taskmanagement.taskmanagement_service.security.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtHelper jwtHelper;

    public User signup(User user) {
        // Check if user already exists
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username is already taken");
        }
        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public String login(String username, String password) {
        try {
            // Authenticate the user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            // Set authentication in the context
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Get user details
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            // Generate and return JWT token
            return jwtHelper.generateToken(userDetails);
        } catch (UsernameNotFoundException | BadCredentialsException e) {
            throw new RuntimeException("Invalid username or password");
        }
    }
}
