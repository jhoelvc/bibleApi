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
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    @Column(name = "identity_document_number", nullable = false, length = 15)
    private String identityDocumentNumber;
    @Column(name = "name", nullable = false, length = 200)
    private String name;
    @Column(name = "contact_number", nullable = false, length = 20)
    private String contactNumber;

    @ManyToOne
    @JoinColumn(name = "identity_document_type_code")
    @JsonIgnore
    private IdentityDocumentType identityDocumentType;
    @ManyToOne
    @JoinColumn(name = "person_type_code")
    @JsonIgnore
    private PersonType personType;
}
