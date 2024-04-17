package com.bible.bibleApi.service;

import com.bible.bibleApi.dto.ServicesDTO;
import com.bible.bibleApi.model.Services;

public interface IServicesService {
    Services create(ServicesDTO services);
    Services update(ServicesDTO services);
    Services findById(Integer code);
    Iterable<Services> findAll();
    void delete(Integer code);
}
