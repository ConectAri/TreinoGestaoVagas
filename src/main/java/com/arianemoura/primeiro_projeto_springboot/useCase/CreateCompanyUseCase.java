package com.arianemoura.primeiro_projeto_springboot.useCase;

import com.arianemoura.primeiro_projeto_springboot.company.entities.CompanyEntity;
import com.arianemoura.primeiro_projeto_springboot.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateCompanyUseCase {

    @Autowired
    CompanyRepository companyRepository;

    private void execute(CompanyEntity companyEntity){


    }


}
