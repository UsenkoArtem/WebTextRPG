package com.art.character.Heroes;

import com.art.character.Character;
import com.art.character.Item;

import java.util.Date;
import java.util.List;

public class Player extends Character {
    private int Point;
    private int time;
    private List<Item> itemList ;
    private List<Item> wearItem;
    private int money;
    private int exp;

    public void addItem(Item item) {
        itemList.add(item.getPosition(), item);
    }
    public void deleteItem(Item item) {
        itemList.remove(item.getPosition());
    }
    public  void regenHealth() {
        if (getTime() != 0 ) {
            int regen = (int) (differenceTime(getTime())*getVitality()*1.14);
            if (regen > getVitality()*14) regen = getVitality() *14; else
                regen = getHealth()+regen;
            setHealth(regen);

        }
    }

    private int differenceTime(int time) {
        Date date = new Date();
        setTime((int) date.getTime());
        return    ((int) (date.getTime() - time));
    }

    public  void regenMana(){

        if (getTime() != 0 ) {
            int regen = (int) (differenceTime(getTime())*getIntelligence()*1.14);
            if (regen > getVitality()*14) regen = getIntelligence()*15; else
                regen = getMana()+regen;
            setMana(regen);

        }

    }
    public void calculateMana() {
        int mana = getIntelligence()*15;
        setMana(mana);
    }

    public void calculateHealth() {
        int health = getVitality()*14;
        setHealth(health);
    }

    public void calculateAttack() {
        int attack = getStrength()*5+getAgility();
        setAttack(attack);
    }
    public void calculateDefense() {
        int defense = getAgility()/7;
        setDefense(defense);
    }

    @Override
    public String toString() {
        return "Player{" +
                "itemList=" + itemList +
                '}';
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addExp(int exp) {
        this.exp+=exp;
        if (this.exp>=getLevel()*100) levelUp();
    }

    public   void levelUp() {
        setExp(getExp()-getLevel()*100);
        setLevel(getLevel()+1);
        setPoint(getPoint()+5);
    }

    public void calculateItem(String items, String wearingItems) {
    }
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }

    public int getPoint() {
        return Point;
    }

    public void setPoint(int point) {
        Point = point;
    }
}
