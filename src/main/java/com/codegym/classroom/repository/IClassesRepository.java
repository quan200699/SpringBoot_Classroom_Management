package com.codegym.classroom.repository;

import com.codegym.classroom.model.Classes;
import com.codegym.classroom.model.Classroom;
import com.codegym.classroom.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassesRepository extends JpaRepository<Classes, Long> {
    Iterable<Classes> findAllByClassroom(Classroom classroom);

    @Query("select l from Lecture l left join Classes c on c.instructor.id = l.id where c.classTime <> ?1 or c.classTime is null")
    Iterable<Lecture> getAllInstructorHasFreeTime(String classTime);
}
