package com.bible.bibleApi.service;

import com.bible.bibleApi.dto.FileStatesDTO;
import com.bible.bibleApi.model.FileStates;

import java.util.List;

public interface IFileStatesService {
    FileStates create(FileStatesDTO fileStatesDTO);
    FileStates update(FileStatesDTO fileStatesDTO);
    FileStates findById(Byte code);
    List<FileStates> findAll();
    void delete(Byte code);
}
