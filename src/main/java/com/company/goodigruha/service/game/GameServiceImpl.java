package com.company.goodigruha.service.game;

import com.company.goodigruha.model.Game;
import com.company.goodigruha.repository.DeveloperRepository;
import com.company.goodigruha.repository.GameRepository;
import com.company.goodigruha.repository.GenreRepository;
import com.company.goodigruha.repository.PlatformRepository;
import com.company.goodigruha.service.game.GameService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final GenreRepository genreRepository;
    private final PlatformRepository platformRepository;
    private final DeveloperRepository developerRepository;

    public List<Game> getAll(){
        return gameRepository.getAll();
    }

    public Optional<Game> getById(Long id){
        return gameRepository.findById(id);
    }

    public Optional<Game> getByTitle(String title){
        return Optional.ofNullable(gameRepository.getByTitleAllIgnoreCase(title));
    }

    public Game save(Game game){
        return gameRepository.save(game);
    }

    public Game update(Game game){
        return gameRepository.save(game);
    }

    public void deleteById(Long id){ gameRepository.deleteById(id);}

    public Game assignGenreToGame(Long genreId, Long gameId){
        val game = gameRepository.findById(gameId).get();
        val genre = genreRepository.findById(genreId).get();
        val genres = game.getGenres();
        genres.add(genre);
        game.setGenres(genres);
        return gameRepository.save(game);
    }

    public Game assignGenreToGame(String genreTitle, String gameTitle){
        val game = gameRepository.getByTitleAllIgnoreCase(gameTitle);
        val genre = genreRepository.getByTitleIgnoreCase(genreTitle);
        val genres = game.getGenres();
        genres.add(genre);
        game.setGenres(genres);
        return gameRepository.save(game);
    }

    public Game assignPlatformToGame(Long platformId, Long gameId){
        val game = gameRepository.findById(gameId).get();
        val platform = platformRepository.findById(platformId).get();
        val platforms = game.getPlatforms();
        platforms.add(platform);
        game.setPlatforms(platforms);
        return gameRepository.save(game);
    }

    public Game assignPlatformToGame(String platformTitle, String gameTitle){
        val game = gameRepository.getByTitleAllIgnoreCase(gameTitle);
        val platform = platformRepository.getByTitleIgnoreCase(platformTitle);
        val platforms = game.getPlatforms();
        platforms.add(platform);
        game.setPlatforms(platforms);
        return gameRepository.save(game);
    }

    public Game assignDeveloperToGame(Long developerId, Long gameId){
        val game = gameRepository.findById(gameId).get();
        val developer = developerRepository.findById(developerId).get();
        val developers = game.getDevelopers();
        developers.add(developer);
        game.setDevelopers(developers);
        return gameRepository.save(game);
    }

    public Game assignDeveloperToGame(String developerTitle, String gameTitle){
        val game = gameRepository.getByTitleAllIgnoreCase(gameTitle);
        val developer = developerRepository.getByTitleIgnoreCase(developerTitle);
        val developers = game.getDevelopers();
        developers.add(developer);
        game.setDevelopers(developers);
        return gameRepository.save(game);
    }
}
