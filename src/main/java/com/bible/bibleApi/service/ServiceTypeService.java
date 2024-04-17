package com.bible.bibleApi.service;

import com.bible.bibleApi.dto.ServiceTypeDTO;
import com.bible.bibleApi.model.ServiceType;
import com.bible.bibleApi.model.Services;
import com.bible.bibleApi.repository.IServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTypeService implements IServiceTypeService{
    @Autowired
    private IServiceTypeRepository serviceTypeRepository;

    @Override
    public ServiceType create(ServiceTypeDTO serviceTypeDTO) {
        ServiceType serviceType = ServiceType.builder()
                .code(serviceTypeDTO.getCode())
                .name(serviceTypeDTO.getName())
                .services(serviceTypeDTO.getServices())
                .build();
        return serviceTypeRepository.save(serviceType);
    }

    @Override
    public ServiceType update(ServiceTypeDTO serviceTypeDTO) {
        ServiceType serviceType = ServiceType.builder()
                .code(serviceTypeDTO.getCode())
                .name(serviceTypeDTO.getName())
                .services(serviceTypeDTO.getServices())
                .build();
        return serviceTypeRepository.save(serviceType);
    }

    @Override
    public ServiceType findById(Integer code) {
        Optional<ServiceType> servicesOptional = serviceTypeRepository.findById(code);
        return servicesOptional.orElse(null);
    }

    @Override
    public List<ServiceType> findAll() {
        return (List<ServiceType>) serviceTypeRepository.findAll();
    }

    @Override
    public void delete(Integer code) {
        serviceTypeRepository.deleteById(code);
    }
}
