package com.art.character.Enemies.Barrens;

import com.art.character.Enemies.AgilityEnemy;

public class Scorpion extends AgilityEnemy {

    public Scorpion(String scorpion, int i, int i1, int i2, int i3, int i4) {

        super(scorpion, i, i1, i2, i3, i4);
    }

    @Override
    public void calculatedStats() {
        int level = getLevel();
        setAgility(getAgility() + level * 4);
        setStrength(getStrength() + (int) (level * 1.5));
        setIntelligence(getIntelligence() + level);
        setVitality((int) (getVitality() + level * 1.8));
        calculateAttack();
        calculateDefense();
        calculateHealth();
        calculateMana();
    }
}
