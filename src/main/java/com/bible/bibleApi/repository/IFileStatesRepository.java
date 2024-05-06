package com.bible.bibleApi.repository;

import com.bible.bibleApi.model.FileStates;
import org.springframework.data.repository.CrudRepository;

public interface IFileStatesRepository extends CrudRepository<FileStates, Integer> {
}
