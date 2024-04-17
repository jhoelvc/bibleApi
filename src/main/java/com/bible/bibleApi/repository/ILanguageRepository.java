package com.bible.bibleApi.repository;

import com.bible.bibleApi.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILanguageRepository extends JpaRepository<Language, Integer> {

}
