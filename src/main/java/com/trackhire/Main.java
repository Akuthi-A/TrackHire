package com.trackhire;


import java.util.ArrayList;
import java.util.Scanner;
import com.trackhire.service.*;
import com.trackhire.model.*;

public class Main {

    public static void main(String[] args) {

        JobService jobService = new JobService();
        Scanner scanner = new Scanner(System.in);

        int choice;
        String companyName;
        String role;


        do {

            System.out.println("\n===== TrackHire SYSTEM =====");

            System.out.println("1. View All Job Applications");
            System.out.println("2. Add Job Application");
            System.out.println("3. Update Job Application");
            System.out.println("4. Remove Job Application");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    // TODO:
                    // View All Job Applications
                    for (JobApplication job: jobService.viewApplications()) {
                        System.out.println(job.toString() + "\n");
                    }

                    break;

                case 2:

                    System.out.print("Enter company name: ");
                    scanner.nextLine(); // clear buffer
                    companyName = scanner.nextLine();

                    System.out.print("Enter role: ");
                    role = scanner.nextLine();

                    System.out.println("Select status: ");
                    System.out.println("1. APPLIED");
                    System.out.println("2. INTERVIEW");
                    System.out.println("3. REJECTED");

                    int statusChoice = scanner.nextInt();

                    Status status = switch (statusChoice) {
                        case 1 -> Status.APPLIED;
                        case 2 -> Status.INTERVIEW;
                        case 3 -> Status.REJECTED;
                        default -> Status.APPLIED;
                    };

                    boolean added = jobService.addJobApplication(companyName, role, status);

                    if (added) {
                        System.out.println("Job application added successfully.");
                    } else {
                        System.out.println("Job application could not be added.");
                    }

                    break;

                case 3:

                    System.out.print("Enter Job ID to update: ");
                    int updateId = scanner.nextInt();

                    System.out.println("What do you want to update?");
                    System.out.println("1. Company Name");
                    System.out.println("2. Role");
                    System.out.println("3. Status");

                    int updateChoice = scanner.nextInt();

                    switch (updateChoice) {

                        case 1:
                            scanner.nextLine();
                            System.out.print("Enter new company name: ");
                            String newCompany = scanner.nextLine();

                            if (jobService.updateCompanyName(updateId, newCompany)) {
                                System.out.println("Company updated successfully.");
                            } else {
                                System.out.println("Job ID not found.");
                            }
                            break;

                        case 2:
                            scanner.nextLine();
                            System.out.print("Enter new role: ");
                            String newRole = scanner.nextLine();

                            if (jobService.updateRole(updateId, newRole)) {
                                System.out.println("Role updated successfully.");
                            } else {
                                System.out.println("Job ID not found.");
                            }
                            break;

                        case 3:
                            System.out.println("Select new status:");
                            System.out.println("1. APPLIED");
                            System.out.println("2. INTERVIEW");
                            System.out.println("3. REJECTED");

                            int newStatusChoice = scanner.nextInt();

                            Status newStatus = switch (newStatusChoice) {
                                case 1 -> Status.APPLIED;
                                case 2 -> Status.INTERVIEW;
                                case 3 -> Status.REJECTED;
                                default -> Status.APPLIED;
                            };

                            if (jobService.updateStatus(updateId, newStatus)) {
                                System.out.println("Status updated successfully.");
                            } else {
                                System.out.println("Job ID not found.");
                            }
                            break;

                        default:
                            System.out.println("Invalid update option.");
                    }

                    break;

                case 4:

                    System.out.print("Enter Job ID to remove: ");
                    int removeId = scanner.nextInt();

                    if (jobService.removeJobApplication(removeId)) {
                        System.out.println("Job removed successfully.");
                    } else {
                        System.out.println("Job ID not found.");
                    }

                    break;

                case 5:

                    System.out.println("Exiting system...");
                    break;

                default:

                    System.out.println("Invalid option.");
            }

        } while (choice != 5);

        scanner.close();
    }
}

