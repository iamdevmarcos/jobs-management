package com.iamdevmarcos.jobs_management.modules.company.repositories;

import com.iamdevmarcos.jobs_management.modules.company.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {
}
