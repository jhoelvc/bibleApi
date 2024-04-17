package com.bible.bibleApi.controller;

import com.bible.bibleApi.dto.ServiceTypeDTO;
import com.bible.bibleApi.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service-type")
public class ServiceTypeController {
    @Autowired
    private ServiceTypeService serviceTypeService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<ServiceTypeDTO> ServiceTypeDTOS = serviceTypeService.findAll()
                .stream()
                .map(serviceType -> ServiceTypeDTO.builder()
                        .code(serviceType.getCode())
                        .name(serviceType.getName())
                        .services(serviceType.getServices())
                        .build())
                .toList();

        return ResponseEntity.ok(ServiceTypeDTOS);
    }
}
