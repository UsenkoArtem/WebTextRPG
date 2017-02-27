package com.art.character;


/**
 * Класс который определяет всех югитов в игре
 */
public class Character  extends  Stats{
    private  String name;
    private  int level;

    private  int time;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Character()
    {}

    public void calculateMana() {
        int mana = 0 ;
        ///Формула для маны
        setMana(mana);
    }
    public void calculateHealth() {}
    public void calculateAttack() {}
    public void calculateDefense() {}
    public  void regenHealth() {}
    public  void regenMana(){}
    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", level=" + level + super.toString();
    }
}
