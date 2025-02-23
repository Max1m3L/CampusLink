package com.maxlvshv.backend.conroller;

import com.maxlvshv.backend.entity.Job;
import com.maxlvshv.backend.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
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
}
