package com.company.goodigruha.api.rest;

import com.company.goodigruha.model.Game;
import com.company.goodigruha.service.game.GameServiceImpl;
import com.company.goodigruha.service.genre.GenreServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/games")
@RequiredArgsConstructor
public class GameController {
    private final GameServiceImpl gameServiceImpl;
    private final GenreServiceImpl genreServiceImpl;

    @GetMapping
    public ResponseEntity<List<Game>> getAll(){
        val games = gameServiceImpl.getAll();
        if (games == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (games.isEmpty()) {
            return new ResponseEntity<>(games, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(games, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Game> getById(@PathVariable Long id){
        return gameServiceImpl
                .getById(id)
                .map(game -> new ResponseEntity<>(game, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Game> save(@RequestBody Game game){
        gameServiceImpl.save(game);
        return new ResponseEntity<>(game, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> update(@PathVariable Long id, @RequestBody Game game){
        if (gameServiceImpl.getById(id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        game.setId(id);
        gameServiceImpl.update(game);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @PutMapping("/{gameId}/genre/{genreId}")
    public ResponseEntity<Game> assignGenreToGame(@PathVariable Long gameId, @PathVariable Long genreId){
        if (gameServiceImpl.getById(gameId).isEmpty() || genreServiceImpl.getById(genreId).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(gameServiceImpl.assignGenreToGame(gameId, genreId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Game> deleteById(@PathVariable Long id){
        val game = gameServiceImpl.getById(id);
        if (game.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        gameServiceImpl.deleteById(id);
        return new ResponseEntity<>(game.get(), HttpStatus.OK);
    }
}
