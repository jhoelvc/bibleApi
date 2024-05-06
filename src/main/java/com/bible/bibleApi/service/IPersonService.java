package com.bible.bibleApi.service;

import com.bible.bibleApi.dto.PersonDTO;
import com.bible.bibleApi.model.Person;

public interface IPersonService {
    Person create(Person person);
    Person update(Person person);
    Person findById(Integer code);
    Iterable<Person> findAll();
    void delete(Integer code);
}
