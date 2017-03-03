package com.art.character.Enemies;

/**
 * Created by Artem on 03.03.2017.
 */
public class IntelligenceEnemy extends Enemy {
    public IntelligenceEnemy(String cultist, int i, int i1, int i2, int i3, int i4) {
        super(cultist,i,i1,i2,i3,i4);
    }

    @Override
    public void calculateMana() {
        setMana(getIntelligence()*7);
    }

    @Override
    public void calculateAttack() {
        setAttack(getIntelligence()*9);
    }
}
