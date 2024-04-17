package com.bible.bibleApi.service;

import com.bible.bibleApi.dto.PersonDTO;
import com.bible.bibleApi.model.Person;
import com.bible.bibleApi.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService{
    @Autowired
    private IPersonRepository personRepository;

    @Override
    public Person create(PersonDTO personDTO) {
        return null;
    }

    @Override
    public Person update(PersonDTO personDTO) {
        Person person = Person.builder()
                .code(personDTO.getCode())
                .name(personDTO.getName())
                .identityDocumentNumber(personDTO.getIdentityDocumentNumber())
                .contactNumber(personDTO.getContactNumber())
                .personType(personDTO.getPersonType())
                .identityDocumentType(personDTO.getIdentityDocumentType())
                .build();
        return personRepository.save(person);
    }

    @Override
    public Person findById(Integer code) {
        return null;
    }

    @Override
    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public void delete(Integer code) {

    }
}
