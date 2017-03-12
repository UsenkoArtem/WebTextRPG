package com.art.character.Enemies.FrozenHIlls;

import com.art.character.Enemies.Enemy;
import com.art.character.Enemies.IntelligenceEnemy;

public class KillerSnowMan extends IntelligenceEnemy {

    public KillerSnowMan(String snowMan, int i, int i1, int i2, int i3, int i4) {
        super(snowMan, i, i1, i2, i3, i4);
    }

    @Override
    public void calculatedStats() {
        int level = getLevel();
        setAgility((int)(getAgility() + level*0.5));
        setStrength((int)(getStrength() + level * 1.5));
        setIntelligence((int)(getIntelligence() + level * Math.exp(2.0)));
        setVitality((int) (getVitality() + level * 0.2));
        calculateAttack();
        calculateDefense();
        calculateHealth();
        calculateMana();
    }
}
