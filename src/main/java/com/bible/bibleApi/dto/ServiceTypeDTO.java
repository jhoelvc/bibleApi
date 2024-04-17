package com.bible.bibleApi.dto;

import com.bible.bibleApi.model.Services;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@Builder
public class ServiceTypeDTO implements Serializable {
    private Integer code;
    private String name;
    private List<Services> services;
}
