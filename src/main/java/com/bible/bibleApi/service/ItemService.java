package com.bible.bibleApi.service;

import com.bible.bibleApi.model.Item;
import com.bible.bibleApi.repository.IItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements IItemService {
    @Autowired
    private IItemRepository itemRepository;

    @Override
    public Item create(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item update(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item findById(Integer code) {
        Optional<Item> itemOptional = itemRepository.findById(code);
        return itemOptional.orElse(null);
    }

    @Override
    public List<Item> findAll() {
        return (List<Item>) itemRepository.findAll();
    }

    @Override
    public void delete(Integer code) {
        itemRepository.deleteById(code);
    }
}
