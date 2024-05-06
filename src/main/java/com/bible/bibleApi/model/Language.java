package com.bible.bibleApi.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
}