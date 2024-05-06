package com.bible.bibleApi.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "file_state")
public class FileStates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte code;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
}
