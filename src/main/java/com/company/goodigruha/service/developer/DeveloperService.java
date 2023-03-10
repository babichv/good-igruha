package com.company.goodigruha.service.developer;

import com.company.goodigruha.model.Developer;

import java.util.List;
import java.util.Optional;

public interface DeveloperService {
    List<Developer> getAll();

    Optional<Developer> getById(Long id);

    Optional<Developer> getByTitle(String title);

    Developer save(Developer developer);

    Developer update(Developer developer);

    void deleteById(Long id);
}
