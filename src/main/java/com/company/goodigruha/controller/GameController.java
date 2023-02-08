package com.company.goodigruha.controller;

import com.company.goodigruha.entity.Game;
import com.company.goodigruha.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v0.1/games")
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> getAll(){
        return gameService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Game> getById(@PathVariable(name = "id") long id){
        return gameService.findById(id);
    }
    @PostMapping
    public ResponseEntity addGame(@RequestBody Game game){
        try {
            gameService.save(game);
            return ResponseEntity.ok("Game saved!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
