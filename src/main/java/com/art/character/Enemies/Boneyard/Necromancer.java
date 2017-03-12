package com.art.character.Enemies.Boneyard;

import com.art.character.Enemies.Enemy;
import com.art.character.Enemies.IntelligenceEnemy;

public class Necromancer  extends IntelligenceEnemy {

    public Necromancer(String necromancer, int i, int i1, int i2, int i3, int i4) {
        super(necromancer, i, i1, i2, i3, i4);
    }

    @Override
    public void calculatedStats() {
        int level = getLevel();
        setAgility(getAgility() + level * 2);
        setStrength(getStrength() + level * 1);
        setIntelligence( (getIntelligence() + (int)(level * 4.5)));
        setVitality (getVitality() + level);
        calculateAttack();
        calculateDefense();
        calculateHealth();
        calculateMana();
    }
}
