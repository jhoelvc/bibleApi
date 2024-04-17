package com.bible.bibleApi.controller;

import com.bible.bibleApi.dto.PersonDTO;
import com.bible.bibleApi.dto.ServicesDTO;
import com.bible.bibleApi.service.PersonService;
import com.bible.bibleApi.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<PersonDTO> servicesDTOS = personService.findAll()
                .stream()
                .map(person -> PersonDTO.builder()
                        .code(person.getCode())
                        .name(person.getName())
                        .identityDocumentNumber(person.getIdentityDocumentNumber())
                        .contactNumber(person.getContactNumber())
                        .personType(person.getPersonType())
                        .identityDocumentType(person.getIdentityDocumentType())
                        .build())
                .toList();

        return ResponseEntity.ok(servicesDTOS);
    }
}
