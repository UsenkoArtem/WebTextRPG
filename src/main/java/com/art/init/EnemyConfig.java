package com.art.init;

import com.art.character.Enemies.Barrens.Cultist;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class EnemyConfig {

    @Bean
    @Scope(value = "prototype")
    public Cultist cultist () {
        return  null;
    }
}
