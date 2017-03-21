package com.art.character.Enemies.FrozenHIlls;

import com.art.character.Enemies.StrengthEnemy;

public class Dragon extends StrengthEnemy {

    public Dragon(String dragon, int i, int i1, int i2, int i3, int i4) {

        super(dragon, i, i1, i2, i3, i4);
    }

    @Override
    public void calculatedStats() {
        int level = getLevel();
        setAgility(getAgility() + level * 2);
        setStrength(getStrength() * level * 4);
        setIntelligence((int) (getIntelligence() + level));
        setVitality((int) (getVitality() + level * Math.PI * 1.3));
        calculateAttack();
        calculateDefense();
        calculateHealth();
        calculateMana();

    }
}
