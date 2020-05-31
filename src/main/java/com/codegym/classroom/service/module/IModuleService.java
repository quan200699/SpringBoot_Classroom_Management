package com.codegym.classroom.service.module;

import com.codegym.classroom.model.Module;
import com.codegym.classroom.model.Program;
import com.codegym.classroom.service.IGeneralService;

public interface IModuleService extends IGeneralService<Module> {
    Iterable<Module> findAllByProgram(Program program);
}
