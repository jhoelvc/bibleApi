package com.bible.bibleApi.controller;

import com.bible.bibleApi.model.Language;
import com.bible.bibleApi.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    @GetMapping
    public List<Language> findAll() {
        return languageService.findAll();
    }

    @PostMapping
    public Language create(@RequestBody Language language) {
        return languageService.create(language);
    }

    @PutMapping
    public Language update(@RequestBody Language language) {
        return languageService.update(language);
    }

    @GetMapping("/{code}")
    public Language findById(@PathVariable("code") Integer code) {
        return languageService.findById(code);
    }

    @DeleteMapping("/{code}")
    public void delete(@PathVariable("code") Integer code) {
        languageService.delete(code);
    }
}
