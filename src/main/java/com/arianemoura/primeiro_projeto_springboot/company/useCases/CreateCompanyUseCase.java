package com.arianemoura.primeiro_projeto_springboot.company.useCases;

import com.arianemoura.primeiro_projeto_springboot.company.entities.CompanyEntity;
import com.arianemoura.primeiro_projeto_springboot.company.repositories.CompanyRepository;
import com.arianemoura.primeiro_projeto_springboot.exceptions.UserFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;


   public CompanyEntity execute(CompanyEntity companyEntity){

       UUID uuid = UUID.randomUUID();
       System.out.println(uuid.toString());  // Deve imprimir algo como '123e4567-e89b-12d3-a456-426614174000'

       this.companyRepository
        .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
            .ifPresent((user) -> {
            throw new UserFoundException();
        });

     return this.companyRepository.save(companyEntity);

    }
}
