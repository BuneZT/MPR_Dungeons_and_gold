package com.dungeons.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
public class Player extends Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int experience;
    private int nextLevelExp;
    private int gold;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Item> itemList = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Quest> questList = new ArrayList<>();

    public List<Quest> getQuestList() {
        return questList;
    }

    public Player() {
        super();
    }

    public Player(int health, int attack, String name, Float critical, int level, Long id, int experience, int nextLevelExp, int gold) {
        super(health, attack, name, critical, level);
        this.id = id;
        this.experience = experience;
        this.nextLevelExp = nextLevelExp;
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setQuestList(List<Quest> questList) {
        this.questList = questList;
    }


    public Player(int health, int attack, String name, Float critical, int level, Long id, int experience, int nextLevelExp, List<Item> itemList, List<Quest> questList) {
        super(health, attack, name, critical, level);
        this.id = id;
        this.experience = experience;
        this.nextLevelExp = nextLevelExp;
        this.itemList = itemList;
        this.questList = questList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getNextLevelExp() {
        return nextLevelExp;
    }

    public void setNextLevelExp(int nextLevelExp) {
        this.nextLevelExp = nextLevelExp;
    }


}
