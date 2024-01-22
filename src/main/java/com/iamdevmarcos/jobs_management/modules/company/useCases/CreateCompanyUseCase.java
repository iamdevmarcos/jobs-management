package com.iamdevmarcos.jobs_management.modules.company.useCases;

import com.iamdevmarcos.jobs_management.exceptions.UserFoundException;
import com.iamdevmarcos.jobs_management.modules.company.entities.CompanyEntity;
import com.iamdevmarcos.jobs_management.modules.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CompanyEntity execute(CompanyEntity companyEntity) {
        this.companyRepository
            .findByCompanyUsernameOrCompanyEmail(companyEntity.getCompanyUsername(), companyEntity.getCompanyEmail())
            .ifPresent(user -> {
                throw new UserFoundException();
            });

        var encodedPassword = passwordEncoder.encode(companyEntity.getCompanyPassword());
        companyEntity.setCompanyPassword((encodedPassword));

        return this.companyRepository.save(companyEntity);
    }
}
