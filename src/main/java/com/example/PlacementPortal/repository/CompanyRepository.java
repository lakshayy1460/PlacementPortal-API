package com.example.PlacementPortal.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.PlacementPortal.entity.Company;

public interface CompanyRepository extends MongoRepository<Company, String> {

    @Query("{}")
    List<Company> findAllCompanies(Pageable pageable);
}
