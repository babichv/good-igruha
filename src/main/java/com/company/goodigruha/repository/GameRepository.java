package com.company.goodigruha.repository;

import com.company.goodigruha.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    @Query("SELECT g FROM Game g")
    List<Game> getAll();

    Game getByTitleAllIgnoreCase(String title);
}


