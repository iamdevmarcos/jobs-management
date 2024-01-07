package com.iamdevmarcos.jobs_management.modules.company.entities;

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

@Entity(name = "company")
@Data
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID companyId;

    @Pattern(regexp = "\\S+", message = "O campo [username] não pode conter espaços.")
    private String companyUsername;

    @Email(message = "O campo [email] deve conter um e-mail válido!")
    private String companyEmail;

    @Length(min = 5, max = 100, message = "O campo [senha] deve conter entre {min} e {max} caracteres.")
    private String companyPassword;

    private String companyWebsite;
    private String companyName;
    private String companyDescription;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
