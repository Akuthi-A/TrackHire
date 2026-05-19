package com.trackhire.service;

import com.trackhire.model.JobApplication;
import com.trackhire.model.Status;

import java.util.ArrayList;

import static com.trackhire.model.Status.APPLIED;

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

    public boolean removeJobApplication(JobApplication job) {
        if (listOfJobApplication.contains(job)) {
            listOfJobApplication.remove(job);
            return true;
        }
        System.out.println("There is no such Job application in our db.");
        return false;
    }

    public boolean removeJobApplication(int id) {
        for (JobApplication job: listOfJobApplication) {
            if (job.getJobID() == id) {
                listOfJobApplication.remove(job);
                return true;
            }
        }
        System.out.println("There is no such Job application in our db.");
        return false;
    }

    public boolean updateJobApplication(int id, String company, String role, Status status) {
        for (JobApplication job: listOfJobApplication) {
            if (job.getJobID() == id) {
                job.setCompanyName(company);
                job.setStatus(status);
                job.setRole(role);
                return true;
            }
        }
        return false;
    }


    public void viewApplications() {
        if (listOfJobApplication.isEmpty()) {
            System.out.println("You do not have any applications saved yet.");
            return;
        }
        for (JobApplication job: listOfJobApplication) {
            System.out.println(job.toString());
        }
    }
}
