package com.dungeons.demo.repository;

import com.dungeons.demo.model.Enemy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnemyRepository extends JpaRepository<Enemy, Long> {

    @Query("SELECT e from Enemy e where e.level = :level ORDER BY :random")
    Optional<Enemy> getRandomEnemy(int level, int random);
}
