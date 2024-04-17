package com.bible.bibleApi.controller;

import com.bible.bibleApi.dto.ServicesDTO;
import com.bible.bibleApi.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/service")
public class ServicesController {
    @Autowired
    private ServicesService servicesService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<ServicesDTO> servicesDTOS = servicesService.findAll()
                .stream()
                .map(services -> ServicesDTO.builder()
                        .code(services.getCode())
                        .name(services.getName())
                        .serviceCodeDependency(services.getServiceCodeDependency())
                        .serviceType(services.getServiceType())
                        .build())
                .toList();

        return ResponseEntity.ok(servicesDTOS);
    }
}
