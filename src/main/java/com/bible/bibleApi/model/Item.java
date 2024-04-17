package com.bible.bibleApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "price", nullable = false, precision = 14, scale = 6, columnDefinition="DECIMAL(14,6)")
    private BigDecimal price;
}
