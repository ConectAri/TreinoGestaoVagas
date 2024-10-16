package com.arianemoura.primeiro_projeto_springboot.useCase;

import com.arianemoura.primeiro_projeto_springboot.candidate.CandidateEntity;
import com.arianemoura.primeiro_projeto_springboot.candidate.CandidateRepository;
import com.arianemoura.primeiro_projeto_springboot.exceptions.UserFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;
    public CandidateEntity execute(CandidateEntity candidateEntity){

        this.candidateRepository
                .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException("Usuário já existe");
                });

        return this.candidateRepository.save(candidateEntity);

    }
}
