package com.arianemoura.primeiro_projeto_springboot.controllers;

import com.arianemoura.primeiro_projeto_springboot.candidate.CandidateEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {


    @PostMapping("/")
    public void creat(@RequestBody CandidateEntity candidateEntity){
        System.out.println("Candidato");
        System.out.println( candidateEntity.getEmail());
    }


}
