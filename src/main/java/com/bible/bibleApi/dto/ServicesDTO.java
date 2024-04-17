package com.bible.bibleApi.dto;

import com.bible.bibleApi.model.ServiceType;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
public class ServicesDTO implements Serializable {
    private Integer code;
    private String name;
    private Integer serviceCodeDependency;
    private ServiceType serviceType;
}
