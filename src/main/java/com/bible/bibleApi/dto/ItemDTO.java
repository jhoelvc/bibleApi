package com.bible.bibleApi.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ToString
@Builder
public class ItemDTO implements Serializable {
    private Integer code;
    private String name;
    private BigDecimal price;
}
