package com.codegym.classroom.repository;

import com.codegym.classroom.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILectureRepository extends JpaRepository<Lecture, Long> {
}
