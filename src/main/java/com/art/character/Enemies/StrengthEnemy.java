package com.art.character.Enemies;

/**
 * Created by Artem on 03.03.2017.
 */
public class StrengthEnemy extends  Enemy {
    @Override
    public void calculateHealth() {
        setHealth(getVitality()*15+getStrength()*2);
    }

    @Override
    public void calculateAttack() {
        setAttack(getStrength()*5);
    }
}
