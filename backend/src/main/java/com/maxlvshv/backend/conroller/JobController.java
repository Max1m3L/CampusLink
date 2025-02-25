package com.maxlvshv.backend.conroller;

import com.maxlvshv.backend.entity.Job;
import com.maxlvshv.backend.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
@Validated
public class JobController {
    public final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public String getAllJobs(Model model) {
        model.addAttribute("jobs", jobService.getAllJobs());
        return "index";
    }

    @GetMapping("/job/{id}")
    public String getJobDetails(@PathVariable Long id, Model model) {
        Job job = jobService.getJobById(id);
        model.addAttribute("job", job);
        return "job-details";
    }

    @GetMapping("/apply/{id}")
    public String showApplyForm(@PathVariable Long id, Model model) {
        model.addAttribute("jobId", id);
        return "apply";
    }

    @PostMapping("/job-add")
    public ResponseEntity<?> addJob(@Valid @RequestBody Job job) {
        try {
            jobService.addJob(job);
            return ResponseEntity.ok("Vacancy is created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Can't create vacancy");
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        try {
            jobService.deleteJob(id);
            return ResponseEntity.ok("Vacancy was deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while deleting the vacancy");
        }
    }

    @GetMapping("/jobs")
    public String getJobs(@RequestParam(required = false) String search,
                          @RequestParam(required = false) String type,
                          Model model) {
        List<Job> jobs = jobService.findJobs(search, type);
        List<String> jobTypes = jobService.getJobTypes();

        model.addAttribute("jobs", jobs);
        model.addAttribute("jobTypes", jobTypes);
        return "index";
    }
}
