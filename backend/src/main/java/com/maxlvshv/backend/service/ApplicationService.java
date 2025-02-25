package com.maxlvshv.backend.service;

import com.maxlvshv.backend.entity.Application;
import com.maxlvshv.backend.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application saveApplication(Application application) {
        return applicationRepository.save(application);
    }

    public List<Application> getAllApplication() {
        return applicationRepository.findAll();
    }

    public void deleteById(Long id) {
        applicationRepository.deleteById(id);
    }
}
