package com.bible.bibleApi.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
public class FileStatesDTO implements Serializable {
    private Byte code;
    private String name;
}
