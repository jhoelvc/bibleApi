package com.bible.bibleApi.controller;

import com.bible.bibleApi.dto.PersonDTO;
import com.bible.bibleApi.dto.TariffDTO;
import com.bible.bibleApi.service.ITariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/tariff")
public class TariffController {
    @Autowired
    private ITariffService tariffService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<TariffDTO> tariffDTOS = tariffService.findAll()
                .stream()
                .map(tariff -> TariffDTO.builder()
                        .code(tariff.getCode())
                        .service(tariff.getService())
                        .person(tariff.getPerson())
                        .price(tariff.getPrice())
                        .packageDetails(tariff.getPackageDetails())
                        .build())
                .toList();

        return ResponseEntity.ok(tariffDTOS);
    }
}
