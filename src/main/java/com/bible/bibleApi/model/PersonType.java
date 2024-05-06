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
@Table(name = "person_type")
public class PersonType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte code;
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Getter
    @OneToMany(mappedBy = "personType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Person> persons;
}
