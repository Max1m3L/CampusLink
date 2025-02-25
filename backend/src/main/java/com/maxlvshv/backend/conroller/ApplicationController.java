package com.maxlvshv.backend.conroller;

import com.maxlvshv.backend.entity.Application;
import com.maxlvshv.backend.entity.Job;
import com.maxlvshv.backend.service.ApplicationService;
import com.maxlvshv.backend.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/apply")
@Validated
public class ApplicationController {
    public final ApplicationService applicationService;
    public final JobService jobService;

    @Autowired
    public ApplicationController(ApplicationService applicationService, JobService jobService) {
        this.applicationService = applicationService;
        this.jobService = jobService;
    }

    @PostMapping("/{jobId}")
    public String submitApplication(@PathVariable Long jobId, @RequestParam String name, @RequestParam String email,
            @RequestParam String message) {

        Job job = jobService.getJobById(jobId);

        Application application = new Application();
        application.setJob(job);
        application.setStudent(name);
        application.setEmail(email);
        application.setMessage(message);

        applicationService.saveApplication(application);

        return "redirect:/";
    }

    @GetMapping("/applications")
    public String getMyApplications(Model model) {
        model.addAttribute("applications", applicationService.getAllApplication());
        return "my-applications";
    }


    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteApplication(@PathVariable Long id) {
        try {
            applicationService.deleteById(id);
            return ResponseEntity.ok("Application was deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while deleting the Application");
        }
    }

}
