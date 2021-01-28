package com.dungeons.demo.service;

import com.dungeons.demo.model.Player;
import com.dungeons.demo.repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private PlayerRepository playerRepository;


    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;

    }

    public Player save(Player player) {
        return playerRepository.save(player);

    }

    public Player update(Player player) {
        if (playerRepository.findById(player.getId()).isEmpty()) {
            throw new RuntimeException();
        } else {
            return playerRepository.save(player);
        }

    }

    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }
}
