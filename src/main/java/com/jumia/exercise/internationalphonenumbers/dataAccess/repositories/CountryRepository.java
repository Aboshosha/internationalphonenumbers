package com.jumia.exercise.internationalphonenumbers.dataAccess.repositories;

import java.util.List;

import com.jumia.exercise.internationalphonenumbers.dataAccess.entities.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {

    List<Country> findByNameIs(String name);

    List<Country> findByCodeIs(String code);

}
