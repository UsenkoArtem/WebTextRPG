package com.art.character.Enemies.FrozenHIlls;

import com.art.character.Enemies.AgilityEnemy;

public class Sabletooth extends AgilityEnemy {

    public Sabletooth(String mummy, int i, int i1, int i2, int i3, int i4) {

        super(mummy, i, i1, i2, i3, i4);
    }

    @Override
    public void calculatedStats() {
        int level = getLevel();
        setAgility(getAgility() + level * 6);
        setStrength((int) (getStrength() + level * Math.E));
        setIntelligence(getIntelligence() + level);
        setVitality((getVitality() + level));
        calculateAttack();
        calculateDefense();
        calculateHealth();
        calculateMana();
    }
}
