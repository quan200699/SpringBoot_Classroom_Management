package com.codegym.classroom.repository;

import com.codegym.classroom.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassesRepository extends JpaRepository<Classes, Long> {
}