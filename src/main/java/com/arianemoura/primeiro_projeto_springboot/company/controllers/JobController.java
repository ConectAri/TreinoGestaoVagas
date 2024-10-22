package com.arianemoura.primeiro_projeto_springboot.company.controllers;

import com.arianemoura.primeiro_projeto_springboot.company.entities.CompanyEntity;
import com.arianemoura.primeiro_projeto_springboot.company.entities.JobEntity;
import com.arianemoura.primeiro_projeto_springboot.company.repositories.CompanyRepository;
import com.arianemoura.primeiro_projeto_springboot.company.useCases.CreateJobUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private CreateJobUseCase createJobUseCase;

    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping("/")
    public JobEntity create(@Valid @RequestBody JobEntity jobEntity){

        CompanyEntity companyEntity = companyRepository.findById(jobEntity.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Company not found"));


        // Associar a empresa ao JobEntity
        jobEntity.setCompanyEntity(companyEntity);

        return this.createJobUseCase.execute(jobEntity);

    }

}
