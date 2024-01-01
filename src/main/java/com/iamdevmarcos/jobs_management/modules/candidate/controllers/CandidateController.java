package com.iamdevmarcos.jobs_management.modules.candidate.controllers;

import com.iamdevmarcos.jobs_management.modules.candidate.entities.CandidateEntity;
import com.iamdevmarcos.jobs_management.modules.candidate.repositories.CandidateRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping
    public CandidateEntity createCandidate(@Valid @RequestBody CandidateEntity candidate) {
        return this.candidateRepository.save(candidate);
    }
}
