package com.dungeons.demo.model;

import javax.persistence.*;

@MappedSuperclass
public class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int health;
    private int attack;
    private String name;
    private int level;

    public Entity(int health, int attack, String name, int level, Long id) {
        this.id = id;
        this.health = health;
        this.attack = attack;
        this.name = name;
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public Entity() {
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
