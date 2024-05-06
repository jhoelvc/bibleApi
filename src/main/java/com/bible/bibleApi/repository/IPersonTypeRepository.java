package com.bible.bibleApi.repository;

import com.bible.bibleApi.model.PersonType;
import org.springframework.data.repository.CrudRepository;

public interface IPersonTypeRepository extends CrudRepository<PersonType, Byte> {
}
