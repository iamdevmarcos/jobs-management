package com.iamdevmarcos.jobs_management.modules.candidate.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Pattern(regexp = "\\S+", message = "O campo [username] não pode conter espaços.")
    private String username;

    @Email(message = "O campo [email] deve conter um e-mail válido!")
    private String email;

    @Length(min = 5, max = 100, message = "O campo [senha] deve conter entre {min} e {max} caracteres.")
    private String password;

    @Length(max = 255)
    private String description;

    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
