package com.art.character.Enemies;

/**
 * Created by Artem on 03.03.2017.
 */
public class AgilityEnemy  extends  Enemy{
    @Override
    public void calculateAttack() {
        setAttack(getAgility()*7);
    }

    @Override
    public void calculateDefense() {
        setDefense(getAgility()/6);

    }
}
