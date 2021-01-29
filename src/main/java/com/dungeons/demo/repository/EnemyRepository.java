package com.dungeons.demo.repository;

import com.dungeons.demo.model.Enemy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnemyRepository extends JpaRepository<Enemy, Long> {

    Optional<Enemy> findByLevel(int level);

}
