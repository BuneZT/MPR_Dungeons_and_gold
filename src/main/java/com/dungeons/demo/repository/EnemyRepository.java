package com.dungeons.demo.repository;

import com.dungeons.demo.model.Enemy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EnemyRepository extends JpaRepository<Enemy, Long> {

    Optional<List<Enemy>> findAllByLevel(int level);

}
