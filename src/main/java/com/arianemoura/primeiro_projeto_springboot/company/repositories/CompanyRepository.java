package com.arianemoura.primeiro_projeto_springboot.company.repositories;

import com.arianemoura.primeiro_projeto_springboot.candidate.CandidateEntity;
import com.arianemoura.primeiro_projeto_springboot.company.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {

    Optional<CompanyEntity> findByUsernameOrEmail(String username, String email); //Validando a busca por e-mail ou nome


}
