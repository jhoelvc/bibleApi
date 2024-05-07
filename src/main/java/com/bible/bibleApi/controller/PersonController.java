package com.bible.bibleApi.controller;

import com.bible.bibleApi.dto.LanguageDTO;
import com.bible.bibleApi.dto.PersonDTO;
import com.bible.bibleApi.model.Person;
import com.bible.bibleApi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/api/person")
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

    @GetMapping("/{code}")
    public ResponseEntity<?> findById(@PathVariable("code") Integer code) {
        Person person = personService.findById(code);

        if (person != null) {
            PersonDTO personDTO = PersonDTO.builder()
                    .code(person.getCode())
                    .name(person.getName())
                    .build();

            return ResponseEntity.ok(personDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PersonDTO personDTO) throws URISyntaxException {
        if (personDTO.getIdentityDocumentNumber().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        personService.create(Person.builder()
                        .name(personDTO.getName())
                        .identityDocumentNumber(personDTO.getIdentityDocumentNumber())
                        .contactNumber(personDTO.getContactNumber())
                .build());

        return ResponseEntity.created(new URI("/v1/api/person")).build();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody PersonDTO personDTO) {
        Person person = personService.findById(personDTO.getCode());

        if(person != null) {
            person.setName(personDTO.getName());
            person.setIdentityDocumentNumber(personDTO.getIdentityDocumentNumber());
            person.setContactNumber(personDTO.getContactNumber());

            return ResponseEntity.ok(personService.update(person));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{code}")
    public void delete(@PathVariable("code") Integer code) {
        personService.delete(code);
    }
}
