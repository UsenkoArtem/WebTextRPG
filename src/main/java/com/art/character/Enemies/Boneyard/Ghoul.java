package com.art.character.Enemies.Boneyard;

import com.art.character.Enemies.AgilityEnemy;


public class Ghoul extends AgilityEnemy {
    public Ghoul(String ghoul, int i, int i1, int i2, int i3, int i4) {

        super(ghoul, i, i1, i2, i3, i4);
    }

    @Override
    public void calculatedStats() {
        int level = getLevel();
        setAgility(getAgility() + level * 5);
        setStrength(getStrength() * 2);
        setIntelligence(getIntelligence() + (int) (level * 0.4));
        setVitality((int) (getVitality() + level * 1.5));
        calculateAttack();
        calculateDefense();
        calculateHealth();
        calculateMana();
    }
}
