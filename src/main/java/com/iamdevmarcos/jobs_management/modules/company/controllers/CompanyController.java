package com.iamdevmarcos.jobs_management.modules.company.controllers;

import com.iamdevmarcos.jobs_management.modules.company.entities.CompanyEntity;
import com.iamdevmarcos.jobs_management.modules.company.useCases.CreateCompanyUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CreateCompanyUseCase createCompanyUseCase;

    @PostMapping
    public ResponseEntity<Object> createCompany(@Valid @RequestBody CompanyEntity companyEntity) {
        try {
            var createdCompany = this.createCompanyUseCase.execute(companyEntity);
            return ResponseEntity.ok().body(createdCompany);
        } catch(Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
