package com.art.init;

import com.art.character.Enemies.Barrens.Cultist;
import com.art.character.Enemies.Barrens.*;
import com.art.character.Enemies.Enemy;
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
        Enemy demon = new Demon("Demon",1,7,7,12,5);
        return  demon;
    }

}
