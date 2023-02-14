package com.company.goodigruha.service;

import com.company.goodigruha.entity.Genre;
import com.company.goodigruha.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    @Autowired
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }
    public List<Genre> getAll(){
        return genreRepository.findAll();
    }
}
