package com.bible.bibleApi.dto;

import com.bible.bibleApi.model.ItemPackageDetail;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@ToString
@Builder
public class ItemDTO implements Serializable {
    private Integer code;
    private String name;
    private BigDecimal price;
    private List<ItemPackageDetail> itemPackageDetails;
}
