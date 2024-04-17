package com.bible.bibleApi.service;

import com.bible.bibleApi.model.Language;
import com.bible.bibleApi.repository.ILanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService implements ILanguageService {
    @Autowired
    private ILanguageRepository languageRepository;

    @Override
    public Language create(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public Language update(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public Language findById(Integer id) {
        Optional<Language> languageOptional = languageRepository.findById(id);
        return languageOptional.orElse(null);
    }

    @Override
    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        languageRepository.deleteById(id);
    }
}
