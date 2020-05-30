package com.codegym.classroom.controller;

import com.codegym.classroom.model.Job;
import com.codegym.classroom.model.Lecture;
import com.codegym.classroom.service.job.IJobService;
import com.codegym.classroom.service.lecture.ILectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private IJobService jobService;

    @Autowired
    private ILectureService lectureService;

    @GetMapping
    public ResponseEntity<Iterable<Job>> getAllJob() {
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Job> createNewJob(@RequestBody Job job) {
        return new ResponseEntity<>(jobService.save(job), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJob(@PathVariable Long id) {
        Optional<Job> jobOptional = jobService.findById(id);
        return jobOptional.map(job -> new ResponseEntity<>(job, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateLanguage(@PathVariable Long id, @RequestBody Job job) {
        Optional<Job> jobOptional = jobService.findById(id);
        return jobOptional.map(job1 -> {
            job.setId(job1.getId());
            return new ResponseEntity<>(jobService.save(job), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Job> deleteJob(@PathVariable Long id) {
        Optional<Job> jobOptional = jobService.findById(id);
        return jobOptional.map(job -> {
            jobService.remove(id);
            return new ResponseEntity<>(job, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/{id}/lectures")
    public ResponseEntity<Iterable<Lecture>> getAllLecture(@PathVariable Long id) {
        Optional<Job> jobOptional = jobService.findById(id);
        return jobOptional.map(job -> new ResponseEntity<>(lectureService.findAllByJob(job), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
