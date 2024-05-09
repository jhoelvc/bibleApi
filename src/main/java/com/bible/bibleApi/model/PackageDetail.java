package com.bible.bibleApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "package_detail")
public class PackageDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    @Column(name = "price", nullable = false, precision = 14, scale = 6, columnDefinition = "DECIMAL(14,6)")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "package_code")
    @JsonIgnore
    private Package apackage;
    @ManyToOne
    @JoinColumn(name = "service_code")
    @JsonIgnore
    private Services services;
    @ManyToOne
    @JoinColumn(name = "tariff_code")
    @JsonIgnore
    private Tariff tariff;
}
