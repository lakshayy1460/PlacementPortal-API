package com.example.PlacementPortal.service;

import java.util.List;
import java.util.Optional;

import com.example.PlacementPortal.entity.Company;
import com.example.PlacementPortal.input.CompanyInput;

public interface CompanyService {

    public List<Company> getAllCompanies(int page, int limit, String sortBy, int sortOrder);

    public Optional<Company> getCompanyById(String id);

    public Company AddCompany(CompanyInput companyInput);

    public Company updateCompany(String id, CompanyInput companyInput);

    public boolean deleteCompany(String id);

}

// page, limit, sortBy, sortDirection