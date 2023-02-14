package com.company.goodigruha.service;

import com.company.goodigruha.entity.Developer;
import com.company.goodigruha.entity.Game;
import com.company.goodigruha.entity.Genre;
import com.company.goodigruha.entity.Platform;
import com.company.goodigruha.repository.DeveloperRepository;
import com.company.goodigruha.repository.GameRepository;
import com.company.goodigruha.repository.GenreRepository;
import com.company.goodigruha.repository.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class GameService {
    @Autowired
    private final GameRepository gameRepository;
    @Autowired
    private final GenreRepository genreRepository;

    @Autowired
    private final PlatformRepository platformRepository;

    @Autowired
    private final DeveloperRepository developerRepository;

    public GameService(
            GameRepository gameRepository,
            GenreRepository genreRepository,
            PlatformRepository platformRepository, DeveloperRepository developerRepository)
    {
        this.gameRepository = gameRepository;
        this.genreRepository = genreRepository;
        this.platformRepository = platformRepository;
        this.developerRepository = developerRepository;
    }

    public List<Game> findAll(){
        return gameRepository.getAll();
    }

    public Optional<Game> findById(Long id){
        return gameRepository.findById(id);
    }

    public Optional<Game> findByTitle(String title){
        return Optional.ofNullable(gameRepository.getByTitleAllIgnoreCase(title));
    }

    public Game save(Game game){
        return gameRepository.save(game);
    }

    public Game update(Game game){
        return gameRepository.save(game);
    }

    public Game assignGenreToGame(Long gameId, Long genreId){
        Set<Genre> genres;
        Game game = gameRepository.findById(gameId).get();
        Genre genre = genreRepository.findById(genreId).get();
        genres = game.getGenres();
        genres.add(genre);
        game.setGenres(genres);
        return gameRepository.save(game);
    }
    public Game assignPlatformToGame(Long gameId, Long platformId){
        Set<Platform> platforms;
        Game game = gameRepository.findById(gameId).get();
        Platform platform = platformRepository.findById(platformId).get();
        platforms = game.getPlatforms();
        platforms.add(platform);
        game.setPlatforms(platforms);
        return gameRepository.save(game);
    }

    public Game assignDeveloperToGame(Long gameId, Long developerId){
        Set<Developer> developers;
        Game game = gameRepository.findById(gameId).get();
        Developer developer = developerRepository.findById(developerId).get();
        developers = game.getDevelopers();
        developers.add(developer);
        game.setDevelopers(developers);
        return gameRepository.save(game);
    }
}
