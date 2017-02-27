package com.art.character;

/**
 * Created by Artem on 24.02.2017.
 */
public class Test {
    public static void main(String[] args) {
        Player player = new Warrior("Artem");
        Character character = new Character();
        System.out.println(player);
        player.addExp(100);
        System.out.println(player);
        player.addExp(300);
        System.out.println(player);
    }
}
