package com.bible.bibleApi.repository;

import com.bible.bibleApi.model.Language;
import org.springframework.data.repository.CrudRepository;

public interface ILanguageRepository extends CrudRepository<Language, Integer> {

}
