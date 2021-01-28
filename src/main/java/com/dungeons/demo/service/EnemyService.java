package com.dungeons.demo.service;

import com.dungeons.demo.model.Enemy;
import com.dungeons.demo.repository.EnemyRepository;
import org.springframework.stereotype.Service;

@Service
public class EnemyService {
    private EnemyRepository enemyRepository;


    public EnemyService(EnemyRepository enemyRepository) {
        this.enemyRepository = enemyRepository;

    }

    public Enemy save(Enemy enemy) {
        return enemyRepository.save(enemy);

    }

    public Enemy update(Enemy enemy) {
        if (enemyRepository.findById(enemy.getId()).isEmpty()) {
            throw new RuntimeException();
        } else {
            return enemyRepository.save(enemy);
        }

    }

    public void deleteById(Long id) {
        enemyRepository.deleteById(id);
    }
}
