package com.company.goodigruha.repository;

import com.company.goodigruha.entity.Game;
import com.company.goodigruha.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    @Query("SELECT g FROM Genre g")
    List<Genre> getAll();
    Genre getByTitleIgnoreCase(String title);
}
