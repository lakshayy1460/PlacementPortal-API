package com.example.PlacementPortal.entity;

public enum JobStatus {

    ACTIVE("active"),
    INACTIVE("inactive");

    public final String status;

    JobStatus(String status) {
        this.status = status;
    }

}
