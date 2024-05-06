package com.bible.bibleApi.dto;

import com.bible.bibleApi.model.Person;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@Builder
public class PersonTypeDTO implements Serializable {
    private Byte code;
    private String name;
    private List<Person> persons;
}
