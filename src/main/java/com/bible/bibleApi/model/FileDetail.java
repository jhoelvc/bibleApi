package com.bible.bibleApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "file_detail")
public class FileDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    @Column(name = "date", nullable = false)
    private Integer date;

    @ManyToOne
    @JoinColumn(name = "file_code")
    @JsonIgnore
    private File file;
    @ManyToOne
    @JoinColumn(name = "package_code")
    @JsonIgnore
    private Package apackage;
    @ManyToOne
    @JoinColumn(name = "service_code")
    @JsonIgnore
    private Services services;
}
