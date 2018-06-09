package com.hibernate.dao;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.repository.CrudRepository;

import com.hibernate.entity.League;

public interface LeagueDao extends CrudRepository<League, Long> {
    List<League> findAll();
    League findByName(@NotNull String name);
}
