package com.arianemoura.primeiro_projeto_springboot.company.useCases;

import com.arianemoura.primeiro_projeto_springboot.company.entities.JobEntity;
import com.arianemoura.primeiro_projeto_springboot.company.repositories.JobRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;


    public JobEntity execute(JobEntity jobEntity){
        return this.jobRepository.save(jobEntity);

    }
}
