package com.dungeons.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
public class Item extends Entity {
    private int cost;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private List<Player> playerList = new ArrayList<>();

    public Item() {
        super();
    }

    public Item(int health, int attack, String name, int level, Long id, int cost) {
        super(health, attack, name, level, id);
        this.cost = cost;
    }

    public Item(int health, int attack, String name, int level, Long id, int cost, List<Player> playerList) {
        super(health, attack, name, level, id);
        this.cost = cost;
        this.playerList = playerList;
    }


    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
