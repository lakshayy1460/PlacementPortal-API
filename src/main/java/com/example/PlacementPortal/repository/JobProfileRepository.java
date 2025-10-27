package com.example.PlacementPortal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.PlacementPortal.entity.JobProfile;

public interface JobProfileRepository extends MongoRepository<JobProfile, String> {

}
