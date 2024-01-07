package com.iamdevmarcos.jobs_management.modules.candidate.controllers;

import com.iamdevmarcos.jobs_management.modules.candidate.entities.CandidateEntity;
import com.iamdevmarcos.jobs_management.modules.candidate.useCases.CreateCandidateUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;

    @PostMapping
    public ResponseEntity<Object> createCandidate(@Valid @RequestBody CandidateEntity candidate) {
      try {
          var result = createCandidateUseCase.execute(candidate);
          return ResponseEntity.ok().body(result);
      } catch (Exception exception) {
          return ResponseEntity.badRequest().body(exception.getMessage());
      }
    }
}
