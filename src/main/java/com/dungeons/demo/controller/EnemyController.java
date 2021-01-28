package com.dungeons.demo.controller;

import com.dungeons.demo.model.Enemy;
import com.dungeons.demo.service.EnemyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enemy")
public class EnemyController {

    private EnemyService enemyService;

    public EnemyController(EnemyService enemyService) {
        this.enemyService = enemyService;

    }

    @GetMapping("/list")
    public ResponseEntity<List<Enemy>> findAll() {
        return ResponseEntity.ok(enemyService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enemy> findById(@PathVariable Long id) {

        Optional<Enemy> optionalEnemy = enemyService.findById((id));


        if (optionalEnemy.isPresent()) {
            return ResponseEntity.ok(optionalEnemy.get());

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Enemy> save(@RequestBody Enemy enemy) {
        return ResponseEntity.ok(enemyService.save(enemy));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        enemyService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Enemy> update(@RequestBody Enemy enemy) {
        return ResponseEntity.ok(enemyService.update(enemy));

    }


}