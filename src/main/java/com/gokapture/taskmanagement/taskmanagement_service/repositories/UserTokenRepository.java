package com.gokapture.taskmanagement.taskmanagement_service.repositories;

import com.gokapture.taskmanagement.taskmanagement_service.models.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserTokenRepository extends JpaRepository<UserToken, Long> {

    // Find a token by username
    Optional<UserToken> findByUser_Username(String username);
}
