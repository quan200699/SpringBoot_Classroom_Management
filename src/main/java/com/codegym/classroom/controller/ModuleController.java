package com.codegym.classroom.controller;

import com.codegym.classroom.model.Module;
import com.codegym.classroom.service.module.IModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/modules")
public class ModuleController {
    @Autowired
    private IModuleService moduleService;

    @GetMapping
    public ResponseEntity<Iterable<Module>> getAllModule() {
        return new ResponseEntity<>(moduleService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Module> createNewModule(@RequestBody Module module) {
        return new ResponseEntity<>(moduleService.save(module), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Module> getModule(@PathVariable Long id) {
        Optional<Module> moduleOptional = moduleService.findById(id);
        return moduleOptional.map(module -> new ResponseEntity<>(module, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Module> updateModule(@PathVariable Long id, @RequestBody Module module) {
        Optional<Module> moduleOptional = moduleService.findById(id);
        return moduleOptional.map(module1 -> {
            module.setId(module1.getId());
            return new ResponseEntity<>(moduleService.save(module), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Module> deleteModule(@PathVariable Long id) {
        Optional<Module> moduleOptional = moduleService.findById(id);
        return moduleOptional.map(module -> {
            moduleService.remove(id);
            return new ResponseEntity<>(module, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
