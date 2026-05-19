package com.trackhire.model;

import java.time.LocalDate;
import java.util.ArrayList;

import com.trackhire.service.JobService;

public class JobApplication {
    private String companyName;
    private String role;
    private LocalDate dateApplied;
    private Status status;
    private final int jobID;

    public JobApplication(String companyName, String role, Status status) {
        this.setCompanyName(companyName);
        this.setRole(role);
        this.setStatus(status);
        this.dateApplied = LocalDate.now();
        JobService.id ++;
        this.jobID = JobService.id;

    }

    public int getJobID() {
        return jobID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getDateApplied() {
        return dateApplied;
    }



    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "JobApplication{" +
                "jobID=" + jobID + '\'' +
                ", companyName='" + companyName + '\'' +
                ", role='" + role + '\'' +
                ", dateApplied=" + dateApplied +
                ", status=" + status +
                '}';
    }
}


