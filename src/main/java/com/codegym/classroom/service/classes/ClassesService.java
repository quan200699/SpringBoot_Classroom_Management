package com.codegym.classroom.service.classes;

import com.codegym.classroom.model.Classes;
import com.codegym.classroom.model.Classroom;
import com.codegym.classroom.model.Lecture;
import com.codegym.classroom.repository.IClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassesService implements IClassesService {
    @Autowired
    private IClassesRepository classesRepository;

    @Override
    public Iterable<Classes> findAll() {
        return classesRepository.findAll();
    }

    @Override
    public Optional<Classes> findById(Long id) {
        return classesRepository.findById(id);
    }

    @Override
    public Classes save(Classes classes) {
        return classesRepository.save(classes);
    }

    @Override
    public void remove(Long id) {
        classesRepository.deleteById(id);
    }

    @Override
    public Iterable<Classes> findAllByClassroom(Classroom classroom) {
        return classesRepository.findAllByClassroom(classroom);
    }

    @Override
    public Iterable<Lecture> getAllInstructorHasFreeTime(String classTime) {
        return classesRepository.getAllInstructorHasFreeTime(classTime);
    }

    @Override
    public Iterable<Classes> findAllByInstructor(Lecture lecture) {
        return classesRepository.findAllByInstructor(lecture);
    }

    @Override
    public Iterable<Classes> findAllByCoach(Lecture lecture) {
        return classesRepository.findAllByCoach(lecture);
    }
}
