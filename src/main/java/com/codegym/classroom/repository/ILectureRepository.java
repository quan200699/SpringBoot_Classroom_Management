package com.codegym.classroom.repository;

import com.codegym.classroom.model.Job;
import com.codegym.classroom.model.Language;
import com.codegym.classroom.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILectureRepository extends JpaRepository<Lecture, Long> {
    Iterable<Lecture> findAllByJob(Job job);

    Iterable<Lecture> findAllByLanguages(Language language);
}
