package com.iamdevmarcos.jobs_management.modules.candidate.useCases;

import com.iamdevmarcos.jobs_management.exceptions.UserFoundException;
import com.iamdevmarcos.jobs_management.modules.candidate.entities.CandidateEntity;
import com.iamdevmarcos.jobs_management.modules.candidate.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CandidateEntity execute(CandidateEntity candidate) {
        this.candidateRepository
                .findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
                .ifPresent(user -> {
                    throw new UserFoundException();
                });

        var encodedPassoword = passwordEncoder.encode(candidate.getPassword());
        candidate.setPassword(encodedPassoword);

        return this.candidateRepository.save(candidate);
    }
}
