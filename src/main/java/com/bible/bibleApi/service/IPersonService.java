package com.bible.bibleApi.service;

import com.bible.bibleApi.dto.PersonDTO;
import com.bible.bibleApi.model.Person;

public interface IPersonService {
    Person create(PersonDTO personDTO);
    Person update(PersonDTO personDTO);
    Person findById(Integer code);
    Iterable<Person> findAll();
    void delete(Integer code);
}
