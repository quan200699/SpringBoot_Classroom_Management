package com.codegym.classroom.controller;

import com.codegym.classroom.model.Lecture;
import com.codegym.classroom.service.lecture.ILectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/lectures")
public class LectureController {
    @Autowired
    private ILectureService lectureService;

    @GetMapping
    public ResponseEntity<Iterable<Lecture>> getAllLecture() {
        return new ResponseEntity<>(lectureService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Lecture> createNewLecture(@RequestBody Lecture lecture) {
        return new ResponseEntity<>(lectureService.save(lecture), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lecture> getLecture(@PathVariable Long id) {
        Optional<Lecture> lectureOptional = lectureService.findById(id);
        return lectureOptional.map(lecture -> new ResponseEntity<>(lecture, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lecture> updateLecture(@PathVariable Long id, @RequestBody Lecture lecture) {
        Optional<Lecture> lectureOptional = lectureService.findById(id);
        return lectureOptional.map(lecture1 -> {
            lecture.setId(lecture1.getId());
            return new ResponseEntity<>(lectureService.save(lecture), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Lecture> deleteLecture(@PathVariable Long id) {
        Optional<Lecture> lectureOptional = lectureService.findById(id);
        return lectureOptional.map(lecture -> {
            lectureService.remove(id);
            return new ResponseEntity<>(lecture, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
