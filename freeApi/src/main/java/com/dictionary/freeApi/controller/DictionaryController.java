package com.dictionary.freeApi.controller;

import com.dictionary.freeApi.model.DictionaryResponse;
import com.dictionary.freeApi.services.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DictionaryController {

    private final DictionaryService dictionaryService;

    @Autowired
    public DictionaryController(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("/wordSearch")
    public ResponseEntity<DictionaryResponse> search(@RequestParam String word) {
        DictionaryResponse response = dictionaryService.search(word);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }
}
