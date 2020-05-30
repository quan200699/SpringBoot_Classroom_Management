package com.codegym.classroom.controller;

import com.codegym.classroom.model.Classes;
import com.codegym.classroom.model.Student;
import com.codegym.classroom.service.classes.IClassesService;
import com.codegym.classroom.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private IClassesService classesService;

    @Autowired
    private IStudentService studentService;

    @GetMapping
    public ResponseEntity<Iterable<Classes>> getAllClasses() {
        return new ResponseEntity<>(classesService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Classes> createNewClasses(@RequestBody Classes classes) {
        return new ResponseEntity<>(classesService.save(classes), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classes> getClasses(@PathVariable Long id) {
        Optional<Classes> classesOptional = classesService.findById(id);
        return classesOptional.map(classes -> new ResponseEntity<>(classes, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Classes> updateClasses(@PathVariable Long id, @RequestBody Classes classes) {
        Optional<Classes> classesOptional = classesService.findById(id);
        return classesOptional.map(classes1 -> {
            classes.setId(classes1.getId());
            return new ResponseEntity<>(classesService.save(classes), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Classes> deleteClasses(@PathVariable Long id) {
        Optional<Classes> classesOptional = classesService.findById(id);
        return classesOptional.map(classes -> {
            classesService.remove(id);
            return new ResponseEntity<>(classes, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<Iterable<Student>> getALlStudentByClasses(@PathVariable Long id) {
        Optional<Classes> classesOptional = classesService.findById(id);
        return classesOptional.map(classes -> new ResponseEntity<>(studentService.findAllByClasses(classes), HttpStatus.OK)
        ).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
