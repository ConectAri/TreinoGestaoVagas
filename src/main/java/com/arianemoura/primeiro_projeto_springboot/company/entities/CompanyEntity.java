package com.arianemoura.primeiro_projeto_springboot.company.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
@Entity(name = "company")
public class CompanyEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36)", unique = true, nullable = false)
    private UUID id;


    @NotBlank
    @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço")
    private String username;

    @Email(message = "O campo [email] deve conter e-mail válido")
    private String email;

    @Length(min = 10, max = 100)
    private String password;
    private String website;
    private String name;
    private String description;
    @CreationTimestamp
    private LocalDateTime createdAt;

}
