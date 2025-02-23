package com.maxlvshv.backend.conroller;

import com.maxlvshv.backend.entity.Application;
import com.maxlvshv.backend.entity.Job;
import com.maxlvshv.backend.entity.Student;
import com.maxlvshv.backend.service.ApplicationService;
import com.maxlvshv.backend.service.JobService;
import com.maxlvshv.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/apply")
public class ApplicationController {
    public final ApplicationService applicationService;
    public final JobService jobService;
    public final StudentService studentService;

    @Autowired
    public ApplicationController(ApplicationService applicationService, JobService jobService, StudentService studentService) {
        this.applicationService = applicationService;
        this.jobService = jobService;
        this.studentService = studentService;
    }


    @PostMapping("/{jobId}")
    public String submitApplication(
            @PathVariable Long jobId,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String message) {

        // Создаем или находим студента
        Student student = studentService.getStudentById(1L); // Временно используем фиксированный ID студента

        // Находим вакансию
        Job job = jobService.getJobById(jobId);

        // Создаем заявку
        Application application = new Application();
        application.setJob(job);
        application.setStudent(student);
        application.setMessage(message);

        // Сохраняем заявку
        applicationService.saveApplication(application);

        return "redirect:/"; // Перенаправляем на страницу с вакансиями
    }
}
