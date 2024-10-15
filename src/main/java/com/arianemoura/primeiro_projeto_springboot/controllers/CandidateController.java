package com.arianemoura.primeiro_projeto_springboot.controllers;

import com.arianemoura.primeiro_projeto_springboot.candidate.CandidateEntity;
import com.arianemoura.primeiro_projeto_springboot.candidate.CandidateRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {


    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping("/")
    public CandidateEntity creat(@Valid @RequestBody CandidateEntity candidateEntity){

        return this.candidateRepository.save(candidateEntity);

    }


}
