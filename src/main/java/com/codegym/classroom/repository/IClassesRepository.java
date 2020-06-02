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

    @Query("select l from Lecture l where l.id not in (select l.id from Lecture l left join Classes c on c.instructor.id = l.id where c.classTime = ?1)")
    Iterable<Lecture> getAllInstructorHasFreeTime(String classTime);

    Iterable<Classes> findAllByInstructor(Lecture lecture);

    Iterable<Classes> findAllByCoach(Lecture lecture);

    @Query("select l from Classes c left join c.tutors l where c.id=?1 and l.id not in(select l.id from Lecture l left join Classes c on c.instructor.id = l.id where c.classTime = ?2) and l.job.id <> ?3")
    Iterable<Lecture> getAllTutorHasFreeTime(Long id, String classTime, Long jobId);
}
