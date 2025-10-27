package com.example.PlacementPortal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PlacementPortal.entity.JobProfile;
import com.example.PlacementPortal.input.JobProfileInput;
import com.example.PlacementPortal.service.JobProfileService;

@RestController
@RequestMapping("/api/jobProfile")
public class JobProfileController {

    @Autowired
    JobProfileService jobProfileService;

    public List<JobProfile> getAllJobProfiles() {
        return jobProfileService.getAllJobProfiles();
    }

    public Optional<JobProfile> getJobProfileById(@PathVariable String id) {
        return jobProfileService.getJobProfileById(id);
    }

    public JobProfile AddJobProfile(@RequestBody JobProfileInput jobProfileInput) {
        return jobProfileService.AddJobProfile(jobProfileInput);
    }

    public JobProfile updateJobProfile(@PathVariable String id, @RequestBody JobProfileInput jobProfileInput) {
        return jobProfileService.updateJobProfile(id, jobProfileInput);
    }

    public boolean deleteJobProfile(@PathVariable String id) {
        return jobProfileService.deleteJobProfile(id);
    }

}
