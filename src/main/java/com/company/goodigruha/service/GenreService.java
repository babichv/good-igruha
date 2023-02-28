package com.company.goodigruha.service;

import com.company.goodigruha.entity.Genre;
import com.company.goodigruha.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GenreService {
    @Autowired
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }
    public List<Genre> getAll(){
        return genreRepository.getAll();
    }

    public Optional<Genre> getById(Long id){
        return Optional.ofNullable(genreRepository.getById(id));
    }

    public Optional<Genre> getByTitle(String title){
        return Optional.ofNullable(genreRepository.getByTitleIgnoreCase(title));
    }

    public Genre save(Genre genre){
        return genreRepository.save(genre);
    }

    public Genre update(Genre genre){
        return genreRepository.save(genre);
    }

    public void deleteById(Long id) { genreRepository.deleteById(id);}
}
