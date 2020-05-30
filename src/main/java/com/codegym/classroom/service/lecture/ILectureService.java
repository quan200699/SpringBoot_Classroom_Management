package com.codegym.classroom.service.lecture;

import com.codegym.classroom.model.Job;
import com.codegym.classroom.model.Language;
import com.codegym.classroom.model.Lecture;
import com.codegym.classroom.service.IGeneralService;

public interface ILectureService extends IGeneralService<Lecture> {
    Iterable<Lecture> findAllByJob(Job job);

    Iterable<Lecture> findAllByLanguages(Language language);
}
