package com.art.character.Heroes;

public class Warrior extends Player {

    public Warrior(String name) {
        setName( name);
        setLevel(1);
        setStrength(30);
        setAgility(15);
        setIntelligence( 10);
        setVitality(30);
        setTime(0);
        calculateAttack();
        calculateMana();
        calculateHealth();
        calculateDefense();
    }

    public   void levelUp() {
        while (getExp()>=getLevel()*100) {
            setExp(getExp() - getLevel() * 100);
            setLevel(getLevel() + 1);
            setAgility(getAgility() + 2);
            setStrength(getStrength() + 4);
            setIntelligence(getIntelligence() + 1);
            setVitality(getVitality() + 5);
            calculateAttack();
            calculateMana();
            calculateHealth();
            calculateDefense();
        }
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "name='" + getName() + '\'' +
                ", level=" + getLevel() +
                ", strength=" + getStrength() +
                ", agility=" + getAgility() +
                ", intelligence=" + getIntelligence() +
                ", vitality=" + getVitality() +
                ", attack=" + getAttack() +
                ", health=" + getHealth() +
                ", mana=" + getMana() +
                ", defense=" + getDefense() +
                ", time=" + getTime() +
                '}';
    }


 }
