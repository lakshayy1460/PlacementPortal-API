package com.example.PlacementPortal.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.PlacementPortal.entity.JobProfile;
import com.example.PlacementPortal.entity.JobStatus;
import com.example.PlacementPortal.input.JobProfileInput;
import com.example.PlacementPortal.repository.JobProfileRepository;
import com.example.PlacementPortal.service.JobProfileService;

@Service
public class JobProfileServiceImpl implements JobProfileService {

    @Autowired
    JobProfileRepository jobProfileRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<JobProfile> getAllJobProfiles(int page, int limit, String sortBy, int sortOrder) {
        Sort sort = Sort.unsorted();
        if (!sortBy.equals("")) {
            Sort.Direction direction = sortOrder == 1 ? Sort.Direction.ASC
                    : (sortOrder == -1 ? Sort.Direction.DESC : null);

            sort = direction == null ? Sort.by(sortBy) : Sort.by(direction, sortBy);
        }
        PageRequest pageRequest = PageRequest.of(page - 1, limit, sort);

        return jobProfileRepository.findAllJobs(pageRequest);
    }

    public Optional<JobProfile> getJobProfileById(String id) {
        Optional<JobProfile> jobFromDB = jobProfileRepository.findById(id);
        return jobFromDB;
    }

    public JobProfile AddJobProfile(JobProfileInput jobProfileInput) {
        JobProfile job = modelMapper.map(jobProfileInput, JobProfile.class);

        job.setStatus(JobStatus.ACTIVE);
        job.setCreatedAt(new Date());
        job.setUpdatedAt(new Date());
        job.setDeleted(false);

        JobProfile jobToAdd = jobProfileRepository.save(job);
        return jobToAdd;
    }

    public JobProfile updateJobProfile(String id, JobProfileInput jobProfileInput) {
        Optional<JobProfile> jobFromDB = jobProfileRepository.findById(id);

        if (jobFromDB.isPresent()) {
            JobProfile job = jobFromDB.get();

            if (jobProfileInput.getTitle() != null) {
                job.setTitle(jobProfileInput.getTitle());
            }
            if (jobProfileInput.getJobDomain() != null) {
                job.setJobDomain(jobProfileInput.getJobDomain());
            }
            if (jobProfileInput.getDescription() != null) {
                job.setDescription(jobProfileInput.getDescription());
            }
            if (jobProfileInput.getLocations() != null) {
                job.setLocations(jobProfileInput.getLocations());
            }
            if (jobProfileInput.getSalaryRange() != null) {
                job.setSalaryRange(jobProfileInput.getSalaryRange());
            }
            if (jobProfileInput.getSelectionProcess() != null) {
                job.setSelectionProcess(jobProfileInput.getSelectionProcess());
            }
            if (jobProfileInput.getLastDateToApply() != null) {
                job.setLastDateToApply(jobProfileInput.getLastDateToApply());
            }

            job.setUpdatedAt(new Date());
            JobProfile updatedJob = jobProfileRepository.save(job);
            return updatedJob;
        }

        return null;

    }

    public boolean deleteJobProfile(String id) {
        Optional<JobProfile> jobFromDB = jobProfileRepository.findById(id);
        if (jobFromDB.isPresent()) {
            JobProfile job = modelMapper.map(jobFromDB, JobProfile.class);
            job.setDeleted(true);
            job.setUpdatedAt(new Date());
            jobProfileRepository.save(job);
            return true;
        }
        return false;
    }

}
