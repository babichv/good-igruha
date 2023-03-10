package com.company.goodigruha.service.genre;

import com.company.goodigruha.model.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    List<Genre> getAll();

    Optional<Genre> getById(Long id);

    Optional<Genre> getByTitle(String title);

    Genre save(Genre genre);

    Genre update(Genre genre);

    void deleteById(Long id);
}
