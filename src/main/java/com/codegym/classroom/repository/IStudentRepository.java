package com.codegym.classroom.repository;

import com.codegym.classroom.model.Classes;
import com.codegym.classroom.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    Iterable<Student> findAllByClasses(Classes classes);
}
