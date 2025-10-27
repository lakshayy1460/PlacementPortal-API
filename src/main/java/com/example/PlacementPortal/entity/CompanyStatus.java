package com.example.PlacementPortal.entity;

public enum CompanyStatus {

    ACTIVE("active"),
    INACTIVE("inactive");

    public final String status;

    CompanyStatus(String status) {
        this.status = status;
    }

}
