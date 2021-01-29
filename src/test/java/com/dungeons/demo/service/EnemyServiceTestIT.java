package com.dungeons.demo.service;

import com.dungeons.demo.model.Enemy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EnemyServiceTestIT {

    @Autowired
    private EnemyService enemyService;

    @BeforeEach
    void cleanUp() {
        enemyService.deleteAll();
    }

    @Test
    void shouldNotFindAnyone() {
        List<Enemy> all = enemyService.findAll();
        Assertions.assertThat(all).isEmpty();
    }

    @Test
    void shouldFindAllEnemies() {
        enemyService.save(new Enemy(25, 25, "test", 1, 2L, 2, 2));
        List<Enemy> all = enemyService.findAll();
        Assertions.assertThat(all).isNotEmpty();
    }

    @Test
    void shouldSaveEnemy() {
        Enemy enemy = enemyService.save(new Enemy(25, 25, "test", 1, 2L, 2, 2));
        Assertions.assertThat(enemy.getId()).isPositive();

    }

    @Test
    void shouldFindById() {
        Enemy enemy = enemyService.save(new Enemy(25, 25, "test", 1, 2L, 2, 2));
        Assertions.assertThat(enemyService.findById(enemy.getId())).isNotEmpty();

    }


}
