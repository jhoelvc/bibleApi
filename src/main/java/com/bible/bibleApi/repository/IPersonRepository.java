package com.bible.bibleApi.repository;

import com.bible.bibleApi.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface IPersonRepository extends CrudRepository<Person, Integer> {
}
