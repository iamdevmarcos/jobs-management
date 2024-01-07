package com.iamdevmarcos.jobs_management.modules.candidate.useCases;

import com.iamdevmarcos.jobs_management.exceptions.UserFoundException;
import com.iamdevmarcos.jobs_management.modules.candidate.entities.CandidateEntity;
import com.iamdevmarcos.jobs_management.modules.candidate.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidate) {
        this.candidateRepository
                .findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
                .ifPresent(user -> {
                    throw new UserFoundException();
                });

        return this.candidateRepository.save(candidate);
    }
}
