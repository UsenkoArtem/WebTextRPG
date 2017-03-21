package com.art.character.Enemies.Woodland;

import com.art.character.Enemies.StrengthEnemy;

public class Bear extends StrengthEnemy {
    public Bear(String bear, int i, int i1, int i2, int i3, int i4) {

        super(bear,i,i1,i2,i3,i4);
    }

    @Override
    public void calculatedStats() {
        int level=getLevel();
        setAgility(getAgility()+level);
        setStrength((int)(getStrength()*level*2));
        setIntelligence((int) (getIntelligence()+level*0.5));
        setVitality((int) (getVitality()+level*Math.E));
        calculateAttack();
        calculateDefense();
        calculateHealth();
        calculateMana();

    }
}
