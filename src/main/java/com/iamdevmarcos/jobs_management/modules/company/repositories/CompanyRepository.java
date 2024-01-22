package com.iamdevmarcos.jobs_management.modules.company.repositories;

import com.iamdevmarcos.jobs_management.modules.company.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
    Optional<CompanyEntity> findByCompanyUsernameOrCompanyEmail(String companyUsername, String companyEmail);
    Optional<CompanyEntity> findByCompanyUsername(String companyUsername);
}
