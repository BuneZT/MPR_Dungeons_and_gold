package com.dungeons.demo.controller;

import com.dungeons.demo.service.DungeonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/dungeon")
public class DungeonController {

    private DungeonService dungeonService;

    public DungeonController(DungeonService dungeonService) {
        this.dungeonService = dungeonService;

    }

    @GetMapping("/{level}/{playerId}")
    public ResponseEntity<String> enterDungeon(@PathVariable int level, @PathVariable Long playerId) {
        return ResponseEntity.ok(dungeonService.enter(playerId, level));


    }
}
