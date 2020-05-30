package com.codegym.classroom.controller;

import com.codegym.classroom.model.Language;
import com.codegym.classroom.model.Lecture;
import com.codegym.classroom.service.language.ILanguageService;
import com.codegym.classroom.service.lecture.ILectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/languages")
public class LanguageController {
    @Autowired
    private ILanguageService languageService;

    @Autowired
    private ILectureService lectureService;

    @GetMapping
    public ResponseEntity<Iterable<Language>> getAllLanguage() {
        return new ResponseEntity<>(languageService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Language> createNewLanguage(@RequestBody Language language) {
        return new ResponseEntity<>(languageService.save(language), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Language> getLanguage(@PathVariable Long id) {
        Optional<Language> languageOptional = languageService.findById(id);
        return languageOptional.map(language -> new ResponseEntity<>(language, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Iterable<Lecture>> getAllLecture(@PathVariable Long id) {
        Optional<Language> languageOptional = languageService.findById(id);
        return languageOptional.map(language -> new ResponseEntity<>(lectureService.findAllByLanguages(language), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Language> updateLanguage(@PathVariable Long id, @RequestBody Language language) {
        Optional<Language> languageOptional = languageService.findById(id);
        return languageOptional.map(language1 -> {
            language.setId(language1.getId());
            return new ResponseEntity<>(languageService.save(language), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Language> deleteLanguage(@PathVariable Long id) {
        Optional<Language> languageOptional = languageService.findById(id);
        return languageOptional.map(language -> {
            languageService.remove(id);
            return new ResponseEntity<>(language, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
