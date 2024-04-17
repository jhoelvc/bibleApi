package com.bible.bibleApi.service;

import com.bible.bibleApi.dto.ServicesDTO;
import com.bible.bibleApi.model.Services;
import com.bible.bibleApi.repository.IServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesService implements IServicesService {
    @Autowired
    private IServicesRepository servicesRepository;

    @Override
    public Services create(ServicesDTO servicesDTO) {
        Services services = Services.builder()
                .code(servicesDTO.getCode())
                .name(servicesDTO.getName())
                .serviceCodeDependency(servicesDTO.getServiceCodeDependency())
                .serviceType(servicesDTO.getServiceType())
                .build();
        return servicesRepository.save(services);
    }

    @Override
    public Services update(ServicesDTO servicesDTO) {
        Services services = Services.builder()
                .code(servicesDTO.getCode())
                .name(servicesDTO.getName())
                .serviceCodeDependency(servicesDTO.getServiceCodeDependency())
                .serviceType(servicesDTO.getServiceType())
                .build();

        return servicesRepository.save(services);
    }

    @Override
    public Services findById(Integer code) {
        Optional<Services> servicesOptional = servicesRepository.findById(code);
        return servicesOptional.orElse(null);
    }

    @Override
    public List<Services> findAll() {
        return (List<Services>) servicesRepository.findAll();
    }

    @Override
    public void delete(Integer code) {
        servicesRepository.deleteById(code);
    }
}
