package com.dungeons.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int enemyCount;
    private int rewardExp;
    private  int rewardGold;
    @JoinColumn(name="enemy_id")
    @ManyToOne
    @JsonIgnore
    private Enemy enemy;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = @JoinColumn(name = "quest_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private List<Player> playerList = new ArrayList<>();

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }


    public Quest(Long id, int enemyCount, int rewardExp, int rewardGold) {
        this.id = id;
        this.enemyCount = enemyCount;
        this.rewardExp = rewardExp;
        this.rewardGold = rewardGold;
    }

    public Quest(Long id, int enemyCount, int rewardExp, int rewardGold, Enemy enemy, List<Player> playerList) {
        this.id = id;
        this.enemyCount = enemyCount;
        this.rewardExp = rewardExp;
        this.rewardGold = rewardGold;
        this.enemy = enemy;
        this.playerList = playerList;
    }

    public Quest(Long id, int enemyCount, int rewardExp, int rewardGold, Enemy enemy) {
        this.id = id;
        this.enemyCount = enemyCount;
        this.rewardExp = rewardExp;
        this.rewardGold = rewardGold;
        this.enemy = enemy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getEnemyCount() {
        return enemyCount;
    }

    public void setEnemyCount(int enemyCount) {
        this.enemyCount = enemyCount;
    }

    public int getRewardExp() {
        return rewardExp;
    }

    public void setRewardExp(int rewardExp) {
        this.rewardExp = rewardExp;
    }

    public int getRewardGold() {
        return rewardGold;
    }

    public void setRewardGold(int rewardGold) {
        this.rewardGold = rewardGold;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
}
