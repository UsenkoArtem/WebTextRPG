package com.art.character.Enemies;

/**
 * Created by Artem on 03.03.2017.
 */
public class AgilityEnemy  extends  Enemy{

    public AgilityEnemy(String name, int i, int i1, int i2, int i3, int i4) {

        super(name,i,i1,i2,i3,i4);
    }

    @Override
    public void calculateAttack() {
        setAttack(getAgility()*6+(int)(getStrength()*0.5));
    }

    @Override
    public void calculateDefense() {
        setDefense(getAgility()*7);

    }

    @Override
    public void calculateHealth() {
        setHealth(getVitality()*5);
    }
}
