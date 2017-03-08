package com.art.character.Enemies.Barrens;

import com.art.character.Enemies.Enemy;
import com.art.character.Enemies.IntelligenceEnemy;


public class Mummy extends IntelligenceEnemy {

    public Mummy(String mummy, int i, int i1, int i2, int i3, int i4)
    {

        super(mummy,i,i1,i2,i3,i4);
    }

    @Override
    public void calculatedStats() {
        int level = getLevel();
        setAgility(getAgility() + level * 2);
        setStrength(getStrength() + level * 2);
        setIntelligence((int) (getIntelligence() + level * 3));
        setVitality((int) (getVitality()  + level*1.4));
        calculateAttack();
        calculateDefense();
        calculateHealth();
        calculateMana();
    }
}
