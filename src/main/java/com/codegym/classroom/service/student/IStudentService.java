package com.codegym.classroom.service.student;

import com.codegym.classroom.model.Classes;
import com.codegym.classroom.model.Student;
import com.codegym.classroom.service.IGeneralService;

public interface IStudentService extends IGeneralService<Student> {
    Iterable<Student> findAllByClasses(Classes classes);
}
