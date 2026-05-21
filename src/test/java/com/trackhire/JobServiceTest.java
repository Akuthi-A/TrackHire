package com.trackhire;


import com.trackhire.model.JobApplication;
import com.trackhire.model.Status;
import com.trackhire.service.JobService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JobServiceTest {

    private JobService jobService;

    @BeforeEach
    void setUp() {
        jobService = new JobService();
    }

    @Test
    void shouldAddJobApplicationSuccessfully() {

        boolean result = jobService.addJobApplication(
                "Capitec",
                "Software Developer",
                Status.APPLIED
        );

        assertTrue(result);
        assertEquals(1, jobService.viewApplications().size());
    }

    @Test
    void shouldFindJobById() {

        jobService.addJobApplication(
                "Standard Bank",
                "Java Developer",
                Status.INTERVIEW
        );

        JobApplication createdJob = jobService.viewApplications().get(0);

        JobApplication foundJob = jobService.findByID(createdJob.getJobID());

        assertNotNull(foundJob);
        assertEquals("Standard Bank", foundJob.getCompanyName());
    }

    @Test
    void shouldReturnNullForInvalidId() {

        JobApplication foundJob = jobService.findByID(999);

        assertNull(foundJob);
    }

    @Test
    void shouldUpdateCompanyNameSuccessfully() {

        jobService.addJobApplication(
                "Old Company",
                "Backend Developer",
                Status.APPLIED
        );

        JobApplication createdJob = jobService.viewApplications().get(0);

        boolean updated = jobService.updateCompanyName(
                createdJob.getJobID(),
                "New Company"
        );

        JobApplication updatedJob = jobService.findByID(createdJob.getJobID());

        assertTrue(updated);
        assertEquals("New Company", updatedJob.getCompanyName());
    }

    @Test
    void shouldUpdateRoleSuccessfully() {

        jobService.addJobApplication(
                "Amazon",
                "Junior Developer",
                Status.APPLIED
        );

        JobApplication createdJob = jobService.viewApplications().get(0);

        boolean updated = jobService.updateRole(
                createdJob.getJobID(),
                "Senior Developer"
        );

        JobApplication updatedJob = jobService.findByID(createdJob.getJobID());

        assertTrue(updated);
        assertEquals("Senior Developer", updatedJob.getRole());
    }

    @Test
    void shouldUpdateStatusSuccessfully() {

        jobService.addJobApplication(
                "Google",
                "Software Engineer",
                Status.APPLIED
        );

        JobApplication createdJob = jobService.viewApplications().get(0);

        boolean updated = jobService.updateStatus(
                createdJob.getJobID(),
                Status.INTERVIEW
        );

        JobApplication updatedJob = jobService.findByID(createdJob.getJobID());

        assertTrue(updated);
        assertEquals(Status.INTERVIEW, updatedJob.getStatus());
    }

    @Test
    void shouldReturnFalseWhenUpdatingInvalidId() {

        boolean updated = jobService.updateStatus(999, Status.REJECTED);

        assertFalse(updated);
    }

    @Test
    void shouldRemoveJobSuccessfully() {

        jobService.addJobApplication(
                "Microsoft",
                "Cloud Engineer",
                Status.APPLIED
        );

        JobApplication createdJob = jobService.viewApplications().get(0);

        boolean removed = jobService.removeJobApplication(
                createdJob.getJobID()
        );

        assertTrue(removed);
        assertEquals(0, jobService.viewApplications().size());
    }

    @Test
    void shouldReturnFalseWhenRemovingInvalidId() {

        boolean removed = jobService.removeJobApplication(999);

        assertFalse(removed);
    }

    @Test
    void shouldReturnAllApplications() {

        jobService.addJobApplication(
                "IBM",
                "Java Developer",
                Status.APPLIED
        );

        jobService.addJobApplication(
                "Oracle",
                "Backend Engineer",
                Status.INTERVIEW
        );

        assertEquals(2, jobService.viewApplications().size());
    }
}
