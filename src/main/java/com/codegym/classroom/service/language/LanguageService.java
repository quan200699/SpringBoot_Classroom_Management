package com.codegym.classroom.service.language;

import com.codegym.classroom.model.Language;
import com.codegym.classroom.repository.ILanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LanguageService implements ILanguageService {
    @Autowired
    private ILanguageRepository languageRepository;

    @Override
    public Iterable<Language> findAll() {
        return languageRepository.findAll();
    }

    @Override
    public Optional<Language> findById(Long id) {
        return languageRepository.findById(id);
    }

    @Override
    public Language save(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public void remove(Long id) {
        languageRepository.deleteById(id);
    }
}
