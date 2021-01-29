package com.dungeons.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
public class Player extends Entity {
    private int experience;
    private int nextLevelExp;
    private int gold;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Item> itemList = new ArrayList<>();


    public Player() {
        super();
    }

    public Player(int health, int attack, String name, int level, Long id, int experience, int nextLevelExp, int gold) {
        super(health, attack, name, level, id);
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


    public Player(int health, int attack, String name, int level, Long id, int experience, int nextLevelExp, List<Item> itemList) {
        super(health, attack, name, level, id);
        this.experience = experience;
        this.nextLevelExp = nextLevelExp;
        this.itemList = itemList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
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

    public int getAllItemsHealth() {
        int health = 0;
        for (int i = 0; i < this.itemList.size(); i++) {
            health += itemList.get(i).getHealth();
        }
        return health;
    }

    public int getAllItemsAttack() {
        int attack = 0;
        for (int i = 0; i < this.itemList.size(); i++) {
            attack += itemList.get(i).getAttack();
        }
        return attack;
    }


}
