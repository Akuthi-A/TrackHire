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
        return removeJobApplication(job);
    }

    public void updateCompanyName(int id, String company) {
        JobApplication job = findByID(id);
        job.setCompanyName(company);
    }

    public void updateRole(int id, String role) {
        JobApplication job = findByID(id);
        job.setRole(role);
    }

    public void updateStatus(int id, Status status) {
        JobApplication job = findByID(id);
        job.setStatus(status);
    }


    public ArrayList<JobApplication> viewApplications() {

        return listOfJobApplication;
//        for (JobApplication job: listOfJobApplication) {
//            System.out.println(job.toString());
//        }
    }
}
