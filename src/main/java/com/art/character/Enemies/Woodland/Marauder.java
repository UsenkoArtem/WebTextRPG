package com.art.character.Enemies.Woodland;
import com.art.character.Enemies.StrengthEnemy;

public class Marauder extends StrengthEnemy {

    public Marauder(String marauder, int i, int i1, int i2, int i3, int i4) {

        super(marauder,i,i1,i2,i3,i4);
    }

    @Override
    public void calculatedStats() {
        int level=getLevel();
        setAgility(getAgility()+level*3);
        setStrength((int)(getStrength()*level*1.5));
        setIntelligence(getIntelligence()+level*2);
        setVitality((int) (getVitality()+level*1.5));
        calculateAttack();
        calculateDefense();
        calculateHealth();
        calculateMana();

    }
}
