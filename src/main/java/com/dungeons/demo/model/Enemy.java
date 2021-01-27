package com.dungeons.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
public class Enemy extends Entity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  int rewardGold;
    private int rewardExp;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "enemy")
    private List<Quest> questList = new ArrayList<>();

    public List<Quest> getQuestList() {
        return questList;
    }

    public void setQuestList(List<Quest> questList) {
        this.questList = questList;
    }

    public Enemy(int health, int attack, String name, Float critical, int level, Long id, int rewardGold, int rewardExp, List<Quest> questList) {
        super(health, attack, name, critical, level);
        this.id = id;
        this.rewardGold = rewardGold;
        this.rewardExp = rewardExp;
        this.questList = questList;
    }

    public Enemy(Long id, int health, int attack, String name, Float critical, int level, int rewardGold, int rewardExp) {
        super(health, attack, name, critical, level);
        this.id = id;
        this.rewardGold = rewardGold;
        this.rewardExp = rewardExp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
