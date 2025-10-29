package com.example.PlacementPortal.service;

import java.util.List;
import java.util.Optional;

import com.example.PlacementPortal.entity.JobProfile;
import com.example.PlacementPortal.input.JobProfileInput;

public interface JobProfileService {

    public List<JobProfile> getAllJobProfiles(int page, int limit, String sortBy, int sortOrder);

    public Optional<JobProfile> getJobProfileById(String id);

    public JobProfile AddJobProfile(JobProfileInput jobProfileInput);

    public JobProfile updateJobProfile(String id, JobProfileInput jobProfileInput);

    public boolean deleteJobProfile(String id);

}
