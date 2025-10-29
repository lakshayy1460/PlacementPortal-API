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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.PlacementPortal.entity.JobProfile;
import com.example.PlacementPortal.input.JobProfileInput;
import com.example.PlacementPortal.service.JobProfileService;

@RestController
@RequestMapping("/api/jobProfile")
public class JobProfileController {

    @Autowired
    JobProfileService jobProfileService;

    @GetMapping("")
    public List<JobProfile> getAllJobProfiles(@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int limit,
            @RequestParam(defaultValue = "") String sortBy,
            @RequestParam(defaultValue = "1") int sortOrder) {
        return jobProfileService.getAllJobProfiles(page, limit, sortBy, sortOrder);
    }

    @GetMapping("/{id}")
    public Optional<JobProfile> getJobProfileById(@PathVariable String id) {
        return jobProfileService.getJobProfileById(id);
    }

    @PostMapping("")
    public JobProfile AddJobProfile(@RequestBody JobProfileInput jobProfileInput) {
        return jobProfileService.AddJobProfile(jobProfileInput);
    }

    @PutMapping("/{id}")
    public JobProfile updateJobProfile(@PathVariable String id, @RequestBody JobProfileInput jobProfileInput) {
        return jobProfileService.updateJobProfile(id, jobProfileInput);
    }

    @DeleteMapping("/{id}")
    public boolean deleteJobProfile(@PathVariable String id) {
        return jobProfileService.deleteJobProfile(id);
    }

}
