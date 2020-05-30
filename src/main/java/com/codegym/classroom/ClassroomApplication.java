package com.codegym.classroom;

import com.codegym.classroom.model.Job;
import com.codegym.classroom.model.Language;
import com.codegym.classroom.service.job.IJobService;
import com.codegym.classroom.service.language.ILanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

import java.util.List;

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
            asp.setId(3L);
            asp.setName("ASP");
            languageService.save(asp);
        }
        if (jobs.isEmpty()) {
            Job fullTime = new Job();
            fullTime.setName("Fulltime");
            jobService.save(fullTime);
            Job partTime1 = new Job();
            partTime1.setName("Partime sáng");
            jobService.save(partTime1);
            Job partTime2 = new Job();
            partTime2.setName("Partime chiều");
            jobService.save(partTime2);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ClassroomApplication.class, args);
    }

}
