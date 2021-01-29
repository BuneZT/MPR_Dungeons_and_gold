package com.dungeons.demo.model;


@javax.persistence.Entity
public class Enemy extends Entity {
    private int rewardGold;
    private int rewardExp;


    public Enemy() {
        super();
    }

    public Enemy(int health, int attack, String name, int level, Long id, int rewardGold, int rewardExp) {
        super(health, attack, name, level, id);
        this.rewardGold = rewardGold;
        this.rewardExp = rewardExp;
    }


    public int getRewardGold() {
        return rewardGold;
    }

    public void setRewardGold(int rewardGold) {
        this.rewardGold = rewardGold;
    }

    public int getRewardExp() {
        return rewardExp;
    }

    public void setRewardExp(int rewardExp) {
        this.rewardExp = rewardExp;
    }
}
