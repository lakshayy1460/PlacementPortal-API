package com.example.PlacementPortal.service;

import java.util.List;
import java.util.Optional;

import com.example.PlacementPortal.entity.Company;

public interface CompanyService {

    public List<Company> getAllCompanies();

    public Optional<Company> getCompanyById(String id);

    public Company AddCompany(Company company);

    public Company updateCompany(String id, Company company);

    public boolean deleteCompany(String id);

}
