package com.dungeons.demo.service;

import com.dungeons.demo.model.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PlayerServiceTestIT {

    @Autowired
    private PlayerService playerService;

    @BeforeEach
    void cleanUp() {
        playerService.deleteAll();
    }

    @Test
    void shouldNotFindAnyone() {
        List<Player> all = playerService.findAll();
        Assertions.assertThat(all).isEmpty();
    }

    @Test
    void shouldFindAllPlayers() {
        playerService.save(new Player(25, 25, "test", 1, 2L, 0, 25, List.of()));
        List<Player> all = playerService.findAll();
        Assertions.assertThat(all).isNotEmpty();
    }

    @Test
    void shouldSavePlayer() {
        Player player = playerService.save(new Player(25, 25, "test", 1, 2L, 0, 25, List.of()));
        Assertions.assertThat(player.getId()).isPositive();

    }

    @Test
    void shouldFindById() {
        Player player = playerService.save(new Player(25, 25, "test", 1, 2L, 0, 25, List.of()));
        Assertions.assertThat(playerService.findById(player.getId())).isNotEmpty();

    }


}
