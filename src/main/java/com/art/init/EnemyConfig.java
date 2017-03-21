package com.art.init;

import com.art.character.Enemies.Enemy;
import com.art.character.Enemies.Barrens.*;
import com.art.character.Enemies.Boneyard.*;
import com.art.character.Enemies.FrozenHIlls.*;
import com.art.character.Enemies.Woodland.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class EnemyConfig {

    @Bean
    @Scope(value = "prototype")
    public Enemy cultist () {
        Enemy cultist = new Cultist("Cultist",1,7,7,12,5);
        cultist.calculatedStats();
        return  cultist;

    }

    @Bean
    @Scope(value = "prototype")
    public Enemy demon() {
         Demon demon = new Demon("Demon",1,7,7,12,5);
         demon.calculatedStats();
         return demon;
    }
    @Bean
    @Scope(value = "prototype")
    public Enemy mummy() {
        Enemy mummy = new Mummy("Mummy",1,7,7,12,5);
        mummy.calculatedStats();
        return  mummy;
    }

    @Bean
    @Scope(value = "prototype")
    public Enemy scorpion() {
        Enemy scorpion = new Scorpion("Scorpion", 1, 7, 7, 12, 5);
        scorpion.calculatedStats();
        return  scorpion;
    }

    @Bean
    @Scope(value = "prototype")
    public Enemy ghost() {
        Enemy enemy =  new Ghost("Ghost",1,7,7,12,5);
        enemy.calculatedStats();
        return  enemy;
    }
    @Bean
    @Scope(value = "prototype")
    public Enemy ghoul() {
        Enemy ghoul =  new Ghoul("Ghoul",1,7,7,12,5);
        ghoul.calculatedStats();
        return  ghoul;
    }
    @Bean
    @Scope(value = "prototype")
    public Enemy necromancer() {
        Enemy necromancer =  new Necromancer("Necromancer",1,7,7,12,5);
        necromancer.calculatedStats();
        return necromancer;
    }
    @Bean
    @Scope(value = "prototype")
    public Enemy skeleton() {
        Enemy skeleton  = new Skeleton("Skeleton",1,7,7,12,5);
        skeleton.calculatedStats();
        return  skeleton;

    }

    @Bean
    @Scope(value = "prototype")
    public Enemy dragon() {
        Enemy dragon = new Dragon("Dragon",1,7,7,12,5);
        dragon.calculatedStats();
        return  dragon;
    }
    @Bean
    @Scope(value = "prototype")
    public Enemy frozenArmor() {
        Enemy frozenArmor = new FrozenArmor("FrozenArmor", 1, 7, 7, 12, 5);
        frozenArmor.calculatedStats();
        return frozenArmor;
    }
    @Bean
    @Scope(value = "prototype")
    public Enemy killerSnowMan() {
        Enemy killerSnowMan = new KillerSnowMan("KillerSnowMan", 1, 7, 7, 12, 5);
        killerSnowMan.calculatedStats();
        return killerSnowMan;
    }
    @Bean
    @Scope(value = "prototype")
    public Enemy sabletooth() {
        Enemy sabletooth = new Sabletooth("Sabletooth", 1, 7, 7, 12, 5);
        sabletooth.calculatedStats();
        return sabletooth;
    }
    @Bean
    @Scope(value = "prototype")
    public Enemy bear() {
        Enemy bear = new Bear("Bear", 1, 7, 7, 12, 5);
        bear.calculatedStats();
        return bear;
    }
    @Bean
    @Scope(value = "prototype")
    public Enemy wolf() {
        Enemy wolf = new Wolf("Wolf", 1, 7, 7, 12, 5);
        wolf.calculatedStats();
        return wolf;
    }
    @Bean
    @Scope(value = "prototype")
    public Enemy marauder() {
        Enemy marauder = new Marauder("Marauder", 1, 7, 7, 12, 5);
        marauder.calculatedStats();
        return marauder;
    }










}
