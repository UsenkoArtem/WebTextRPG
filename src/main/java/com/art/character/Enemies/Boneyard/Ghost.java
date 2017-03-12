package com.art.character.Enemies.Boneyard;

import com.art.character.Enemies.Enemy;
import com.art.character.Enemies.IntelligenceEnemy;


public class Ghost extends IntelligenceEnemy {

    public Ghost(String ghost, int i, int i1, int i2, int i3, int i4)
    {
        super(ghost,i,i1,i2,i3,i4);
    }

    @Override
    public void calculatedStats() {
        int level = getLevel();
        setAgility(getAgility() + level * 3);
        setStrength((int)(getStrength() + level * 0.8));
        setIntelligence( (getIntelligence() + level * 5));
        setVitality( (getVitality() + level * 2));
        calculateAttack();
        calculateDefense();
        calculateHealth();
        calculateMana();
    }
}
