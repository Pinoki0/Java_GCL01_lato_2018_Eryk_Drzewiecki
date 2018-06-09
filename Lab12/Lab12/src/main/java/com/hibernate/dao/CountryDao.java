package com.hibernate.dao;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.data.repository.CrudRepository;

import com.hibernate.entity.Country;


public interface CountryDao extends CrudRepository<Country, Long> {
    List<Country> findAll();
    Country findByName(@NotNull String name);
}
