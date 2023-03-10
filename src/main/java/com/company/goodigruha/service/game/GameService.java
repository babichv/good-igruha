package com.company.goodigruha.service.game;

import com.company.goodigruha.model.Game;

import java.util.List;
import java.util.Optional;

public interface GameService {
    List<Game> getAll();

    Optional<Game> getById(Long id);

    Optional<Game> getByTitle(String title);

    Game save(Game game);

    Game update(Game game);

    void deleteById(Long id);

    Game assignGenreToGame(Long genreId, Long gameId);

    Game assignGenreToGame(String genreTitle, String gameTitle);

    Game assignPlatformToGame(Long platformId, Long gameId);

    Game assignPlatformToGame(String platformTitle, String gameTitle);

    Game assignDeveloperToGame(Long developerId, Long gameId);

    Game assignDeveloperToGame(String developerTitle, String gameTitle);
}
