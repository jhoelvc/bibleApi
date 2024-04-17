package com.bible.bibleApi.dto;

import com.bible.bibleApi.model.IdentityDocumentType;
import com.bible.bibleApi.model.PersonType;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
public class PersonDTO implements Serializable {
    private Integer code;
    private String identityDocumentNumber;
    private String name;
    private String contactNumber;
    private IdentityDocumentType identityDocumentType;
    private PersonType personType;
}
