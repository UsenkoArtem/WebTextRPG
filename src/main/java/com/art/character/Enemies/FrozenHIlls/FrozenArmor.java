package com.art.character.Enemies.FrozenHIlls;

import com.art.character.Enemies.Enemy;
import com.art.character.Enemies.StrengthEnemy;

public class FrozenArmor extends StrengthEnemy {
    public FrozenArmor(String frozenArmor, int i, int i1, int i2, int i3, int i4) {

        super(frozenArmor,i,i1,i2,i3,i4);
    }

    @Override
    public void calculatedStats() {
        int level=getLevel();
        setAgility(getAgility()+level*3);
        setStrength(getStrength()*level*2);
        setIntelligence((int) (getIntelligence()+level*0.5));
        setVitality((int) (getVitality()+level*Math.PI));
        calculateAttack();
        calculateDefense();
        calculateHealth();
        calculateMana();

    }
}
