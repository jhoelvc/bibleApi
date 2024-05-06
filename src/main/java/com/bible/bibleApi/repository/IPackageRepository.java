package com.bible.bibleApi.repository;

import com.bible.bibleApi.model.Package;
import org.springframework.data.repository.CrudRepository;

public interface IPackageRepository extends CrudRepository<Package, Integer> {
}
