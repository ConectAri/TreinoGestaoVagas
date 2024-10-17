package com.arianemoura.primeiro_projeto_springboot.company.repositories;

import com.arianemoura.primeiro_projeto_springboot.company.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {

}
