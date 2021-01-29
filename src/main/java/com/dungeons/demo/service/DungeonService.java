package com.dungeons.demo.service;

import com.dungeons.demo.model.Enemy;
import com.dungeons.demo.model.Player;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DungeonService {

    private PlayerService playerService;

    private EnemyService enemyService;

    public DungeonService(PlayerService playerService, EnemyService enemyService) {
        this.playerService = playerService;
        this.enemyService = enemyService;

    }

    public String enter(Long playerId, int level) {

        Optional<Player> player = playerService.findById(playerId);

        if (player.isEmpty()) {
            throw new RuntimeException();
        }

        Optional<Enemy> enemy = enemyService.getRandomEnemy(level);

        if (this.fight(player.get(), enemy.get())) {

            return this.playerService.processWin(player.get(), enemy.get());

        }

        return this.playerService.processFailure(player.get(), enemy.get());

    }

    private Boolean fight(Player player, Enemy enemy) {

        int playerHealth = player.getHealth();
        int enemyHealth = enemy.getHealth();
        while (playerHealth > 0) {
            enemyHealth -= player.getAttack();
            if (enemyHealth < 0) {
                return true;
            }
            playerHealth -= enemy.getAttack();

        }

        return false;
    }
}
