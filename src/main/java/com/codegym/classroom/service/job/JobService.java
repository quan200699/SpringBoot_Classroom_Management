package com.codegym.classroom.service.job;

import com.codegym.classroom.model.Job;
import com.codegym.classroom.repository.IJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobService implements IJobService {
    @Autowired
    private IJobRepository jobRepository;

    @Override
    public Iterable<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Optional<Job> findById(Long id) {
        return jobRepository.findById(id);
    }

    @Override
    public Job save(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public void remove(Long id) {
        jobRepository.deleteById(id);
    }
}
