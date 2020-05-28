package com.codegym.classroom.service.classroom;

import com.codegym.classroom.model.Classroom;
import com.codegym.classroom.repository.IClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassroomService implements IClassroomService {
    @Autowired
    private IClassroomRepository classroomRepository;

    @Override
    public Iterable<Classroom> findAll() {
        return classroomRepository.findAll();
    }

    @Override
    public Optional<Classroom> findById(Long id) {
        return classroomRepository.findById(id);
    }

    @Override
    public Classroom save(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public void remove(Long id) {
        classroomRepository.deleteById(id);
    }
}
