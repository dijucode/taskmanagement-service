package com.gokapture.taskmanagement.taskmanagement_service.services;

import com.gokapture.taskmanagement.taskmanagement_service.models.User;
import com.gokapture.taskmanagement.taskmanagement_service.models.UserToken;
import com.gokapture.taskmanagement.taskmanagement_service.repositories.UserRepository;
import com.gokapture.taskmanagement.taskmanagement_service.repositories.UserTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserTokenService {

    @Autowired
    private UserTokenRepository userTokenRepository;
    @Autowired
    private UserRepository userRepository;

    public void saveToken(String username, String token) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserToken userToken = UserToken.builder()
                .user(user)
                .token(token)
                .createdAt(LocalDateTime.now()) // Add current date and time
                .build();

        userTokenRepository.save(userToken);
    }

    public Optional<UserToken> getTokenByUsername(String username) {
        return userTokenRepository.findByUser_Username(username);
    }


}
