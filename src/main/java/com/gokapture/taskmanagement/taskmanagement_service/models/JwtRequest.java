package com.gokapture.taskmanagement.taskmanagement_service.models;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "jwt_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class JwtRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;



}
