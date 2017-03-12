package com.art.character.Enemies.Barrens;

import com.art.character.Enemies.Enemy;
import com.art.character.Enemies.StrengthEnemy;


public class Demon extends StrengthEnemy {

    public Demon(String demon, int i, int i1, int i2, int i3, int i4) {

        super(demon,i,i1,i2,i3,i4);
    }

    @Override
    public void calculatedStats() {
        int level=getLevel();
        setAgility(getAgility()+level*2);
        setStrength(getStrength()*level*3);
        setIntelligence((int) (getIntelligence()*0.5+level*0.5));
        setVitality((int) (getVitality()+level*Math.PI*1.2));
        calculateAttack();
        calculateDefense();
        calculateHealth();
        calculateMana();

    }

}
