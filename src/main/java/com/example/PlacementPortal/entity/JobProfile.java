package com.example.PlacementPortal.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class JobProfile {

    @Id
    private String id;

    private String title;

    private String jobDomain;

    private String description;

    private List<String> locations;

    private SalaryRange salaryRange;

    private String selectionProcess;

    private Date lastDateToApply;

    private int appliedCandidates;

    private int placedCandidates;

    private JobStatus status;

    private Date createdAt;

    private Date updatedAt;

    private boolean isDeleted;

}

// Job Example
// {
// jobId: "JOB12345",
// title: "Software Engineer",
// jobDomain: "IT Services",
// description: "Join our dynamic team to develop cutting-edge software
// solutions that drive innovation and efficiency.",
// locations: ["Bangalore", "Hyderabad"],
// salaryRange: { min: 600000, max: 1200000 },
// selectionProcess: "1. Initial screening of resumes to shortlist candidates.
// \n 2. "In-depth technical assessment to evaluate coding skills and
// problem-solving abilities." \n 3. Discussion about cultural fit, career
// aspirations, and company values.",
// eligibilityCriteria: "Bachelor's degree in Computer Science or related field.
// Minimum 60% in academics. Strong problem-solving skills and proficiency in
// programming languages such as Java, Python, or C++.",
// postedDate: "2024-06-15",
// lastDateToApply: "2024-07-15",
// appliedCandidates: 150,
// placedCandidates: 10,
// status: "active"
//  }