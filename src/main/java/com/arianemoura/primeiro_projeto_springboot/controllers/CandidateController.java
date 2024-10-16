package com.arianemoura.primeiro_projeto_springboot.controllers;

import com.arianemoura.primeiro_projeto_springboot.candidate.CandidateEntity;
import com.arianemoura.primeiro_projeto_springboot.useCase.CreateCandidateUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> creat(@Valid @RequestBody CandidateEntity candidateEntity) {

        try {
            var result = this.createCandidateUseCase.execute(candidateEntity);
            return ResponseEntity.ok().body(result);
        }catch (Exception e){

            return ResponseEntity.badRequest().body(e.getMessage());

        }

    }
}
