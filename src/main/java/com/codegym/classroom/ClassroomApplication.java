package com.codegym.classroom;

import com.codegym.classroom.model.Job;
import com.codegym.classroom.model.Language;
import com.codegym.classroom.service.job.IJobService;
import com.codegym.classroom.service.job.JobService;
import com.codegym.classroom.service.language.ILanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ClassroomApplication {
    @Autowired
    private IJobService jobService;

    @Autowired
    private ILanguageService languageService;

    @PostConstruct
    public void init() {
        List<Job> jobs = (List<Job>) jobService.findAll();
        List<Language> languages = (List<Language>) languageService.findAll();
        if (languages.isEmpty()) {
            Language java = new Language();
            java.setId(1L);
            java.setName("Java");
            languageService.save(java);
            Language php = new Language();
            php.setId(2L);
            php.setName("PHP");
            languageService.save(php);
            Language asp = new Language();
            php.setId(3L);
            php.setName("ASP");
            languageService.save(asp);
        }
        if (jobs.isEmpty()) {
            Job fullTime = new Job();
            fullTime.setName("Fulltime");
            jobService.save(fullTime);
            Job partTime = new Job();
            fullTime.setName("Partime sáng");
            jobService.save(partTime);
            partTime = new Job();
            fullTime.setName("Partime chiều");
            jobService.save(partTime);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ClassroomApplication.class, args);
    }

}
