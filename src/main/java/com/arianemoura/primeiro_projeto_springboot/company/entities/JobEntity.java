package com.arianemoura.primeiro_projeto_springboot.company.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "job")
public class JobEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(columnDefinition = "CHAR(36)", unique = true, nullable = false)
//    private String id;

    @Id
    @Column(columnDefinition = "CHAR(36)", unique = true, nullable = false)
    private String id; // UUID armazenado como string

    private String description;

    private String benefits;

    @NotBlank(message = "Esse campo é obrigatório")
    private String level;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false) // Chave estrangeira na tabela job
    private CompanyEntity companyEntity;


    @CreationTimestamp
    private LocalDateTime createAt;


    @Transient
    private String companyId; // Usado apenas para capturar o ID da empresa na requisição


    @PrePersist
    public void prePersist() {
        // Gera o UUID como string antes de persistir no banco
        if (id == null) {
            id = UUID.randomUUID().toString();
        }

    }

}
