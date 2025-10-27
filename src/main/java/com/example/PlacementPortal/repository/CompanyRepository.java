package com.example.PlacementPortal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.PlacementPortal.entity.Company;

public interface CompanyRepository extends MongoRepository<Company, String> {

}
