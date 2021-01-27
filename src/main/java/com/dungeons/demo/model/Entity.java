package com.dungeons.demo.model;

public class Entity {
    private int health;
    private int attack;
    private  String name;
    private  Float critical;
    private int level;

    public Entity(int health, int attack, String name, Float critical, int level) {
        this.health = health;
        this.attack = attack;
        this.name = name;
        this.critical = critical;
        this.level = level;
    }

    public int getHealth() {
        return health;
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

    public Float getCritical() {
        return critical;
    }

    public void setCritical(Float critical) {
        this.critical = critical;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
