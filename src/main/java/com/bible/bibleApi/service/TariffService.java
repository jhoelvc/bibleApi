package com.bible.bibleApi.service;

import com.bible.bibleApi.dto.TariffDTO;
import com.bible.bibleApi.model.Person;
import com.bible.bibleApi.model.Tariff;
import com.bible.bibleApi.repository.ITariffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TariffService implements ITariffService {
    @Autowired
    private ITariffRepository tariffRepository;

    @Override
    public Tariff create(TariffDTO tariffDTO) {
        Tariff tariff = Tariff.builder()
                .code(tariffDTO.getCode())
                .service(tariffDTO.getService())
                .person(tariffDTO.getPerson())
                .price(tariffDTO.getPrice())
                .build();
        return tariffRepository.save(tariff);
    }

    @Override
    public Tariff update(TariffDTO tariffDTO) {
        Tariff tariff = Tariff.builder()
                .code(tariffDTO.getCode())
                .service(tariffDTO.getService())
                .person(tariffDTO.getPerson())
                .price(tariffDTO.getPrice())
                .build();
        return tariffRepository.save(tariff);
    }

    @Override
    public Tariff findById(Integer code) {
        Optional<Tariff> tariffOptional = tariffRepository.findById(code);
        return tariffOptional.orElse(null);
    }

    @Override
    public List<Tariff> findAll() {
        return (List<Tariff>) tariffRepository.findAll();
    }

    @Override
    public void delete(Integer code) {
        tariffRepository.deleteById(code);
    }
}
