package com.art.character.Enemies.Barrens;


import com.art.character.Enemies.IntelligenceEnemy;

public class Cultist extends IntelligenceEnemy {


    public Cultist(String cultist, int i, int i1, int i2, int i3, int i4) {
        super(cultist, i, i1, i2, i3, i4);
    }

    @Override
    public void calculatedStats() {
        int level = getLevel();
        setAgility(getAgility() + level * 2);
        setStrength(getStrength() + level * 1);
        setIntelligence((getIntelligence() + level * 4));
        setVitality((int) (getVitality() + level * 0.8));
        calculateAttack();
        calculateDefense();
        calculateHealth();
        calculateMana();
    }


}
