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
public class Company {

    @Id
    private String id;

    private String email;

    private String description;

    private String logoUrl;

    private String linkedinUrl;

    private String website;

    private List<String> jobIds;

    private CompanyStatus status;

    private Date registeredAtCollege;

    private Date updatedAt;

    private boolean isDeleted;

}

// {
// name: "Infosys",
// email: "infosys@123.com",
// description: "Infosys is a global leader in next-generation digital services
// and consulting. We enable clients in 46 countries to navigate their digital
// transformation.",
// logo: "https://example.com/logos/infosys.png",
// website: "https://www.infosys.com",
// resigteredAtCollege: "2022-08-09",
// jobIds: ["JOB12345", "JOB67890"],
// status: "Active"
// }
