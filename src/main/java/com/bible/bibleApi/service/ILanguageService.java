package com.bible.bibleApi.service;

import com.bible.bibleApi.model.Language;

import java.util.List;

public interface ILanguageService {
    Language create(Language language);
    Language update(Language language);
    Language findById(Integer code);
    List<Language> findAll();
    void delete(Integer code);
}
