package com.gokapture.taskmanagement.taskmanagement_service.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "jwt_responses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class JwtResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String username;

    private String jwtToken;


}
