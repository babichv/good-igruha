package com.company.goodigruha.service;

import com.company.goodigruha.model.Genre;
import com.company.goodigruha.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService{

    private final GenreRepository genreRepository;

    public List<Genre> getAll(){
        return genreRepository.getAll();
    }

    public Optional<Genre> getById(Long id){
        return genreRepository.findById(id);
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
