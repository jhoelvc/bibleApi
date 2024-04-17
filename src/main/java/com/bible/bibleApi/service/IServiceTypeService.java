package com.bible.bibleApi.service;

import com.bible.bibleApi.dto.ServiceTypeDTO;
import com.bible.bibleApi.model.ServiceType;

public interface IServiceTypeService {
    ServiceType create(ServiceTypeDTO serviceTypeDTO);
    ServiceType update(ServiceTypeDTO serviceTypeDTO);
    ServiceType findById(Integer code);
    Iterable<ServiceType> findAll();
    void delete(Integer code);
}
