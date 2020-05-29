package com.codegym.classroom.repository;

import com.codegym.classroom.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IModuleRepository extends JpaRepository<Module, Long> {
}
