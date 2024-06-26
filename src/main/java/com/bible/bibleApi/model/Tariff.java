package com.bible.bibleApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tariff")
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    @Column(name = "price", nullable = false, precision = 14, scale = 6)
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "service_code")
    @JsonIgnore
    private Services service;
    @ManyToOne
    @JoinColumn(name = "person_code")
    @JsonIgnore
    private Person person;

    @Getter
    @OneToMany(mappedBy = "tariff", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<PackageDetail> packageDetails;
}
