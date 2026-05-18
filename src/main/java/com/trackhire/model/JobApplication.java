package com.trackhire.model;

import java.time.LocalDate;

public class JobApplication {
    static int id = 0;
    private String companyName;
    private String role;
    private LocalDate dateApplied;
    private Status status;
    private int jobID;

    public JobApplication(String companyName, String role, Status status) {
        this.setCompanyName(companyName);
        this.setRole(role);
        this.setStatus(status);
        this.dateApplied = LocalDate.now();
        this.jobID = id;
        id++;
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


