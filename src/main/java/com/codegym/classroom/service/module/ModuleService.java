package com.codegym.classroom.service.module;

import com.codegym.classroom.model.Module;
import com.codegym.classroom.repository.IModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModuleService implements IModuleService {
    @Autowired
    private IModuleRepository moduleRepository;

    @Override
    public Iterable<Module> findAll() {
        return moduleRepository.findAll();
    }

    @Override
    public Optional<Module> findById(Long id) {
        return moduleRepository.findById(id);
    }

    @Override
    public Module save(Module module) {
        return moduleRepository.save(module);
    }

    @Override
    public void remove(Long id) {
        moduleRepository.deleteById(id);
    }
}
