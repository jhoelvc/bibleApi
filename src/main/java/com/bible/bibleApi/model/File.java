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
@Table(name = "file")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    @Column(name = "person_endorse_code", nullable = false)
    private Integer personEndorseCode;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "in_date", nullable = false)
    private Integer inDate;
    @Column(name = "out_date", nullable = false)
    private Integer outDate;

    @ManyToOne
    @JoinColumn(name = "language_code")
    @JsonIgnore
    private Language language;
    @ManyToOne
    @JoinColumn(name = "person_code")
    @JsonIgnore
    private Person person;
    @ManyToOne
    @JoinColumn(name = "file_state_code")
    @JsonIgnore
    private FileStates fileStates;

    @Getter
    @OneToMany(mappedBy = "file", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<FileDetail> fileDetails;
}
