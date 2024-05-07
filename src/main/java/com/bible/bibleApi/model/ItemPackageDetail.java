package com.bible.bibleApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "item_package_detail")
public class ItemPackageDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;

    @ManyToOne
    @JoinColumn(name = "item_code")
    @JsonIgnore
    private Item item;
    @ManyToOne
    @JoinColumn(name = "package_code")
    @JsonIgnore
    private Package apackage;
}
