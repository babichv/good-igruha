package com.company.goodigruha.service;

import com.company.goodigruha.entity.Game;
import com.company.goodigruha.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GameService {
    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
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
}
