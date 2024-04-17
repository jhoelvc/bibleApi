package com.bible.bibleApi.dto;

import com.bible.bibleApi.model.Person;
import com.bible.bibleApi.model.Services;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ToString
@Builder
public class TariffDTO implements Serializable {
    private Integer code;
    private Services service;
    private Person person;
    private BigDecimal price;
}
