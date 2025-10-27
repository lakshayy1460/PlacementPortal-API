package com.example.PlacementPortal.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PlacementPortal.entity.Company;
import com.example.PlacementPortal.entity.CompanyStatus;
import com.example.PlacementPortal.input.CompanyInput;
import com.example.PlacementPortal.repository.CompanyRepository;
import com.example.PlacementPortal.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Optional<Company> getCompanyById(String id) {
        Optional<Company> companyFromDB = companyRepository.findById(id);
        return companyFromDB;
    }

    public Company AddCompany(CompanyInput companyInput) {
        Company company = modelMapper.map(companyInput, Company.class);

        company.setRegisteredAtCollege(new Date());
        company.setUpdatedAt(new Date());
        company.setDeleted(false);
        company.setStatus(CompanyStatus.ACTIVE);

        Company companyToAdd = companyRepository.save(company);
        return companyToAdd;
    }

    public Company updateCompany(String id, CompanyInput companyInput) {
        Optional<Company> companyFromDB = companyRepository.findById(id);

        if (companyFromDB.isPresent()) {
            Company company = companyFromDB.get();

            if (companyInput.getEmail() != null) {
                company.setEmail(companyInput.getEmail());
            }
            if (companyInput.getDescription() != null) {
                company.setDescription(companyInput.getDescription());
            }
            if (companyInput.getLogoUrl() != null) {
                company.setLogoUrl(companyInput.getLogoUrl());
            }
            if (companyInput.getLinkedinUrl() != null) {
                company.setLinkedinUrl(companyInput.getLinkedinUrl());
            }
            if (companyInput.getWebsite() != null) {
                company.setWebsite(companyInput.getWebsite());
            }

            company.setUpdatedAt(new Date());
            Company updatedCompany = companyRepository.save(company);
            return updatedCompany;
        }
        return null;

    }

    public boolean deleteCompany(String id) {

        Optional<Company> companyFromDB = companyRepository.findById(id);

        if (companyFromDB.isPresent()) {
            Company company = modelMapper.map(companyFromDB, Company.class);
            company.setDeleted(true);
            company.setUpdatedAt(new Date());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

}
