package com.arianemoura.primeiro_projeto_springboot.candidate;

import lombok.Data;

import java.util.UUID;


@Data
public class CandidateEntity {

    private UUID id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String descriptions;
    private String curriculum;



}
