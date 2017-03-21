package com.art.character.Enemies.Boneyard;

import com.art.character.Enemies.StrengthEnemy;

public class Skeleton extends StrengthEnemy {
    public Skeleton(String skeleton, int i, int i1, int i2, int i3, int i4) {

        super(skeleton, i, i1, i2, i3, i4);
    }

    @Override
    public void calculatedStats() {
        int level = getLevel();
        setAgility(getAgility() + level);
        setStrength(getStrength() * level * 2);
        setIntelligence((int) (getIntelligence() * 0.5 + level * 0.5));
        setVitality((int) (getVitality() + level * Math.PI * 1.5));
        calculateAttack();
        calculateDefense();
        calculateHealth();
        calculateMana();

    }

}
