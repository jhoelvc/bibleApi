package com.bible.bibleApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "identity_document_type")
public class IdentityDocumentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte code;
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Getter
    @OneToMany(mappedBy = "identityDocumentType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Person> persons;
}
