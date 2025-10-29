package com.example.PlacementPortal.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.PlacementPortal.entity.JobProfile;

public interface JobProfileRepository extends MongoRepository<JobProfile, String> {

    @Query("{}")
    List<JobProfile> findAllJobs(Pageable pageable);
}
