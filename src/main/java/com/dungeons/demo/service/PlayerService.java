package com.dungeons.demo.service;

import com.dungeons.demo.model.Enemy;
import com.dungeons.demo.model.Player;
import com.dungeons.demo.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    private PlayerRepository playerRepository;

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Optional<Player> findById(Long id) {

        return playerRepository.findById(id);
    }


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

    public String processWin(Player player, Enemy enemy) {
        player.setExperience(player.getExperience() + enemy.getRewardExp());
        player.setGold(player.getGold() + enemy.getRewardGold());
        if (player.getExperience() >= player.getNextLevelExp()) {
            player.setHealth(player.getHealth() + 2);
            player.setAttack(player.getAttack() + 2);
            player.setLevel(player.getLevel() + 1);
            player.setNextLevelExp(player.getExperience() * 2);
        }
        this.update(player);
        return "Wygrana!";
    }

    public String processFailure(Player player, Enemy enemy) {
        player.setExperience(player.getExperience() - enemy.getRewardExp());
        player.setGold(player.getGold() - enemy.getRewardGold());
        this.update(player);
        return "Przegrana!";
    }

}
