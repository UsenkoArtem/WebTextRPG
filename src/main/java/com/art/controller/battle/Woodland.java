package com.art.controller.battle;

import com.art.init.EnemyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/battle/woodland")
public class Woodland {
    @Autowired
    private EnemyConfig enemyConfig;

    @RequestMapping(value = "/bear", method = RequestMethod.GET)
    public String battleBear(ModelMap map) {
        map.put("Bear", enemyConfig.bear());
        return "BattleBear";
    }

    @RequestMapping(value = "/wolf", method = RequestMethod.GET)
    public String battleWolf(ModelMap map) {
        map.put("Wolf", enemyConfig.wolf());
        return "BattleWolf";
    }

    @RequestMapping(value = "/marauder", method = RequestMethod.GET)
    public String battleMarauder(ModelMap map) {
        map.put("Marauder", enemyConfig.marauder());
        return "BattleMarauder";
    }
}
