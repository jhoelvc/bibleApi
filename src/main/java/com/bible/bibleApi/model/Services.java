package com.bible.bibleApi.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "service")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    @Column(name = "name")
    private String name;
    @Column(name = "service_code_dependency")
    private Integer serviceCodeDependency;
    @ManyToOne
    @JoinColumn(name = "service_type_code", nullable = false)
    @JsonIgnore
    private ServiceType serviceType;
}
