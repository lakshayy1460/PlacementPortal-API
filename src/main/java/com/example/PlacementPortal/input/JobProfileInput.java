package com.example.PlacementPortal.input;

import java.sql.Date;
import java.util.List;

import com.example.PlacementPortal.entity.SalaryRange;

import lombok.Data;

@Data
public class JobProfileInput {

    private String title;

    private String jobDomain;

    private String description;

    private List<String> locations;

    private SalaryRange salaryRange;

    private String selectionProcess;

    private Date lastDateToApply;

}
