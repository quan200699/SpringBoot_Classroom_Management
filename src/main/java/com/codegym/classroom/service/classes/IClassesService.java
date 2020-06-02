package com.codegym.classroom.service.classes;

import com.codegym.classroom.model.Classes;
import com.codegym.classroom.model.Classroom;
import com.codegym.classroom.model.Lecture;
import com.codegym.classroom.service.IGeneralService;

public interface IClassesService extends IGeneralService<Classes> {
    Iterable<Classes> findAllByClassroom(Classroom classroom);

    Iterable<Lecture> getAllInstructorHasFreeTime(String classTime);

    Iterable<Classes> findAllByInstructor(Lecture lecture);

    Iterable<Classes> findAllByCoach(Lecture lecture);

    Iterable<Lecture> getAllTutorHasFreeTime(Long id, String classTime);
}
