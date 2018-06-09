package com.hibernate.dao;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.repository.CrudRepository;

import com.hibernate.entity.Club;

public interface ClubDao extends CrudRepository<Club, Long> {
    List<Club> findAll();
    Club findByName(@NotNull String name);
}

