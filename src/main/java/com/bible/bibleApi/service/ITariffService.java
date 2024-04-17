package com.bible.bibleApi.service;

import com.bible.bibleApi.dto.TariffDTO;
import com.bible.bibleApi.model.Tariff;

import java.util.List;

public interface ITariffService {
    Tariff create(TariffDTO tariffDTO);
    Tariff update(TariffDTO tariffDTO);
    Tariff findById(Integer id);
    List<Tariff> findAll();
    void delete(Integer id);
}
