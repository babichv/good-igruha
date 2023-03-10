package com.company.goodigruha.repository;

import com.company.goodigruha.model.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class GameRepositoryTest {
    @Autowired
    private GameRepository underTest;

    @AfterEach
    void tearDown(){
        underTest.deleteAll();
    }
    @Test
    void test(){

    }
    @Test
    void itShouldCheckIfGameExistTitle(){
        Game game = new Game();
        game.setTitle("Metro");
        underTest.save(game);
        Game expectedGame = underTest.getByTitleAllIgnoreCase(game.getTitle());
        assertThat(expectedGame.getTitle()).isEqualTo(game.getTitle());
    }
}