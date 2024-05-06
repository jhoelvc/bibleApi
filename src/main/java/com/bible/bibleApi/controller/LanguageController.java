package com.bible.bibleApi.controller;

import com.bible.bibleApi.dto.LanguageDTO;
import com.bible.bibleApi.model.Language;
import com.bible.bibleApi.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/api/language")
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<LanguageDTO> languageDTOList = languageService.findAll()
                .stream()
                .map(language -> LanguageDTO.builder()
                        .code(language.getCode())
                        .name(language.getName())
                        .build())
                .toList();

        return ResponseEntity.ok(languageDTOList);
    }

    @GetMapping("/{code}")
    public ResponseEntity<LanguageDTO> findById(@PathVariable("code") Integer code) {
        Language language = languageService.findById(code);

        if(language != null) {
            LanguageDTO languageDTO = LanguageDTO.builder()
                    .code(language.getCode())
                    .name(language.getName())
                    .build();

            return ResponseEntity.ok(languageDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody LanguageDTO languageDTO) throws URISyntaxException {
        if (languageDTO.getName().isBlank() || languageDTO.getName().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        languageService.create(Language.builder()
                        .name(languageDTO.getName())
                .build());
        return ResponseEntity.created(new URI("/language/create")).build();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody LanguageDTO languageDTO) {
        Language language = languageService.findById(languageDTO.getCode());

        if(language != null) {
            language.setName(languageDTO.getName());

            return ResponseEntity.ok(languageService.create(language));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{code}")
    public void delete(@PathVariable("code") Integer code) {
        languageService.delete(code);
    }
}
