package com.bible.bibleApi.repository;

import com.bible.bibleApi.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface IItemRepository extends CrudRepository<Item, Integer> {

}
