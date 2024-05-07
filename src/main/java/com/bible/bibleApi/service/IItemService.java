package com.bible.bibleApi.service;

import com.bible.bibleApi.model.Item;

import java.util.List;

public interface IItemService {
    Item create(Item item);
    Item update(Item item);
    Item findById(Integer code);
    List<Item> findAll();
    void delete(Integer code);
}
