package com.trackhire.service;

import com.trackhire.model.JobApplication;
import com.trackhire.model.Status;

import java.util.ArrayList;

public class JobService {
    public static int id = 0;
    private ArrayList<JobApplication> listOfJobApplication;

    public JobService() {
        listOfJobApplication = new ArrayList<>();
    }

    public boolean addJobApplication(JobApplication job) {
        if (listOfJobApplication.contains(job)) return false;

        listOfJobApplication.add(job);
        return true;
    }

    public void addJobApplication(String companyName, String role, Status status) {
        JobApplication job = new JobApplication(companyName, role, status);
        listOfJobApplication.add(job);
    }

    public int findByID(int id) {
        for (JobApplication job : listOfJobApplication) {
            if (job.getJobID() == id) {
                return (listOfJobApplication.indexOf(job));
            }
        }
        return -1;
    }

    public boolean removeJobApplication(JobApplication job) {
        if (listOfJobApplication.contains(job)) {
            listOfJobApplication.remove(job);
            return true;
        }
        return false;
    }


    public boolean removeJobApplication(int id) {
        int jobIndex = findByID(id);
        if (jobIndex == -1) return false;
        JobApplication job = listOfJobApplication.get(jobIndex);
        return removeJobApplication(job);
    }

    public boolean updateCompanyName(int id, String company) {
        int jobIndex = findByID(id);
        if (jobIndex == -1) return false;
        JobApplication job = listOfJobApplication.get(jobIndex);
        job.setCompanyName(company);
        return true;
    }

    public boolean updateRole(int id, String role) {
        int jobIndex = findByID(id);
        if (jobIndex == -1) return false;
        JobApplication job = listOfJobApplication.get(jobIndex);
        job.setRole(role);
        return true;
    }

    public boolean updateStatus(int id, Status status) {
        int jobIndex = findByID(id);
        if (jobIndex == -1) return false;
        JobApplication job = listOfJobApplication.get(jobIndex);
        job.setStatus(status);
        return true;
    }


    public ArrayList<JobApplication> viewApplications() {
        return listOfJobApplication;

    }
}
