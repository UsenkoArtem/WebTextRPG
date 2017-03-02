package com.art.character.Enemies;

import com.art.character.Character;

public class Enemy extends Character {

    public  Enemy(String name , int level,int strength, int agility, int intelligence, int vitality) {
       super(name, level, strength, agility, intelligence, vitality);
    }

    public Enemy() {

    }
    private  int exp;

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

}
