package com.art.character.Enemies.Woodland;

import com.art.character.Enemies.AgilityEnemy;


public class Wolf extends AgilityEnemy {

        public Wolf(String wolf, int i, int i1, int i2, int i3, int i4)
        {

            super(wolf,i,i1,i2,i3,i4);
        }

        @Override
        public void calculatedStats() {
            int level = getLevel();
            setAgility(getAgility() + level * 3);
            setStrength(getStrength() + (level * 2));
            setIntelligence (getIntelligence() + level);
            setVitality((int) (getVitality()+level*Math.E));
            calculateAttack();
            calculateDefense();
            calculateHealth();
            calculateMana();
        }
}
