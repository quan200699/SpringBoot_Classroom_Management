package com.codegym.classroom;

import com.codegym.classroom.model.Classroom;
import com.codegym.classroom.model.Job;
import com.codegym.classroom.model.Language;
import com.codegym.classroom.service.classroom.IClassroomService;
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

    @Autowired
    private IClassroomService classroomService;

    @PostConstruct
    public void init() {
        List<Classroom> classrooms = (List<Classroom>) classroomService.findAll();
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
        if (classrooms.isEmpty()) {
            Classroom classroom1 = new Classroom();
            classroom1.setName("Tầng 3 TT01");
            classroom1.setCapacity(49);
            classroomService.save(classroom1);
            Classroom classroom2 = new Classroom();
            classroom2.setName("Tầng 4 TT01");
            classroom2.setCapacity(45);
            classroomService.save(classroom2);
            Classroom classroom3 = new Classroom();
            classroom3.setName("Tầng 1 TT04");
            classroom3.setCapacity(36);
            classroomService.save(classroom3);
            Classroom classroom4 = new Classroom();
            classroom4.setName("Tầng 2 TT04");
            classroom4.setCapacity(30);
            classroomService.save(classroom4);
            Classroom classroom5 = new Classroom();
            classroom5.setName("Tầng 3 TT04");
            classroom5.setCapacity(36);
            classroomService.save(classroom5);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ClassroomApplication.class, args);
    }

}
