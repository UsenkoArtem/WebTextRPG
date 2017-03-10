package com.art.character;

import com.art.character.Heroes.Player;
import com.art.character.Heroes.Warrior;

public class Test {

    public static void main(String[] args) {
        Player player = new Warrior("faf");
        player.calculateItem(null,null);
        System.out.println(player);
    }
}
