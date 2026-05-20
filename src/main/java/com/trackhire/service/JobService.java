package com.trackhire.service;

import com.trackhire.model.JobApplication;
import com.trackhire.model.Status;

import java.util.ArrayList;

public class JobService {
    private static int id = 0;
    private ArrayList<JobApplication> listOfJobApplication;

    public JobService() {
        listOfJobApplication = new ArrayList<>();
    }

    public boolean addJobApplication(JobApplication job) {
        if (listOfJobApplication.contains(job)) return false;

        listOfJobApplication.add(job);
        return true;
    }

    public boolean addJobApplication(String companyName, String role, Status status) {
        JobApplication job = new JobApplication(companyName, role, status, id);
        id++;
        return addJobApplication(job);
    }

    public JobApplication findByID(int id) {
        for (JobApplication job : listOfJobApplication) {
            if (job.getJobID() == id) {
                return job;
            }
        }
        return null;
    }

    public boolean removeJobApplication(JobApplication job) {
        if (listOfJobApplication.contains(job)) {
            listOfJobApplication.remove(job);
            return true;
        }
        return false;
    }


    public boolean removeJobApplication(int id) {
        JobApplication job = findByID(id);
        if (job == null) return false;
        return removeJobApplication(job);
    }

    public boolean updateCompanyName(int id, String company) {
        JobApplication job = findByID(id);
        if (job == null) return false;
        job.setCompanyName(company);
        return true;
    }

    public boolean updateRole(int id, String role) {
        JobApplication job = findByID(id);
        if (job == null) return false;
        job.setRole(role);
        return true;
    }

    public boolean updateStatus(int id, Status status) {
        JobApplication job = findByID(id);
        if (job == null) return false;
        job.setStatus(status);
        return true;
    }


    public ArrayList<JobApplication> viewApplications() {
        return listOfJobApplication;

    }
}
