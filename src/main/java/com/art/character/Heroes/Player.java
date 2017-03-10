package com.art.character.Heroes;

import com.art.character.Character;
import com.art.dao.ItemDAO;
import com.art.model.Item;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class Player extends Character {

    @Autowired
    ItemDAO itemDAO;

    private int Point;
    private int time;
    private List<Item> itemList;
    private Item[] wearItem = new Item[3];
    private int money;
    private int exp;

    public void addItem(Item item) {
        wearItem[item.getPosition()]= item;
        addStrength(item.getStrength());
        addAgility(item.getAgility());
        addVitality(item.getVitality());
        addIntelligence(item.getIntelligence());
        setAttack(getAttack()+item.getAttack());
        setDefense(getDefense()+item.getDefense());
        setHealth(getHealth()+item.getHealth());
        setMana(getMana()+item.getMana());

    }

    public void unequip(int position){
        itemList.add(wearItem[position]);
        wearItem[position]=null;

    }

    public void deleteItem(int position) {
        itemList.remove(position);
    }

    public void regenHealth() {
        if (getTime() != 0) {
            int regen = (int) (differenceTime(getTime()) * getVitality() * 1.14);
            if (regen > getVitality() * 14) regen = getVitality() * 14;
            else
                regen = getHealth() + regen;
            setHealth(regen);

        }
    }

    private int differenceTime(int time) {
        Date date = new Date();
        setTime((int) date.getTime());
        return ((int) (date.getTime() - time));
    }

    public void regenMana() {

        if (getTime() != 0) {
            int regen = (int) (differenceTime(getTime()) * getIntelligence() * 1.14);
            if (regen > getVitality() * 14) regen = getIntelligence() * 15;
            else
                regen = getMana() + regen;
            setMana(regen);

        }

    }

    public void calculateMana() {
        int mana = getIntelligence() * 15;
        for ( Item item :wearItem) {
            if (item!=null)  mana += item.getMana();
        }
        setMana(mana);
    }

    public void calculateHealth() {
        int health = getVitality() * 14;
        for ( Item item :wearItem) {
            if (item!=null)   health += item.getHealth();
        }
        setHealth(health);
    }

    public void calculateAttack() {
        int attack = getStrength() * 5 + getAgility();
        for ( Item item :wearItem) {
          if (item!=null)  attack+= item.getAttack();
        }
        setAttack(attack);
    }

    public void calculateDefense() {
        int defense = getAgility() / 7;
        for ( Item item :wearItem) {
            if (item!=null)  defense += item.getDefense();
        }
        setDefense(defense);
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
        this.exp += exp;
        if (this.exp >= getLevel() * 100) levelUp();
    }

    private void levelUp() {
        while (getExp() > getLevel() * 100) {
            setExp(getExp() - getLevel() * 100);
            setLevel(getLevel() + 1);
            setPoint(getPoint() + 5);
        }
    }

    public void calculateItem(String items, String wearingItems) {

        if (!(items1==null|items1.isEmpty())) {
        String[] split = items.split(",");
        for (String aSplit : split) {
            itemList.add(itemDAO.findById(Integer.parseInt(aSplit)));
        }}
        if (!(wearingItems==null|wearingItems.isEmpty())) {
            String[] split1 = wearingItems.split(",");
            for (String aSplit1 : split1) {
                addItem(itemDAO.findById(Integer.parseInt(aSplit1)));
            }
        }
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

    public void addStrength(int point) {
        setStrength(getStrength() + point);
        calculateAttack();
    }

    public void addVitality(int point) {
        setVitality(getVitality() + point);
        calculateAttack();
        calculateHealth();
    }

    public void addIntelligence(int point) {
        setIntelligence(getIntelligence() + point);
        calculateAttack();
        calculateMana();
    }

    public void addAgility(int point) {
        setAgility(getAgility() + point);
        calculateAttack();
        calculateDefense();
    }

    @Override
    public String toString() {
        return "Player{" +
                "itemDAO=" + itemDAO +
                ", Point=" + Point +
                ", time=" + time +
                ", itemList=" + itemList +
                ", wearItem=" + wearItem +
                ", money=" + money +
                ", exp=" + exp +
                '}';
    }
}
