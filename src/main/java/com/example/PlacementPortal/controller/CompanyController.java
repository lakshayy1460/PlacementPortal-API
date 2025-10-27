package com.example.PlacementPortal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PlacementPortal.entity.Company;
import com.example.PlacementPortal.input.CompanyInput;
import com.example.PlacementPortal.service.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public Optional<Company> getCompanyById(@PathVariable String id) {
        return companyService.getCompanyById(id);
    }

    @PostMapping("")
    public Company AddCompany(@RequestBody CompanyInput companyInput) {
        return companyService.AddCompany(companyInput);
    }

    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable String id, @RequestBody CompanyInput comapnyInput) {
        return companyService.updateCompany(id, comapnyInput);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCompany(@PathVariable String id) {
        return companyService.deleteCompany(id);
    }

}
