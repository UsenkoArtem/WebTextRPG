package com.art.controller.battle;

import com.art.character.Heroes.Mage;
import com.art.character.Heroes.Player;
import com.art.character.Heroes.Rogue;
import com.art.character.Heroes.Warrior;
import com.art.init.EnemyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/battle/woodland")
public class Woodland {
    @Autowired
    private EnemyConfig enemyConfig;
    @Autowired
    private HttpServletRequest req;

    @RequestMapping(value = "/bear", method = RequestMethod.GET)
    public String battleBear(ModelMap map) {

        String type = (String) req.getSession().getAttribute("type");
        Player player;
        switch (type) {
            case "Warrior":
                player = (Warrior) req.getSession().getAttribute("user");

                break;
            case "Rogue":
                player = (Rogue) req.getSession().getAttribute("user");
                ;

                break;
            case "Mage":
                player = (Mage) req.getSession().getAttribute("user");
                ;

                break;
            default:
                player = null;
                break;
        }


        map.put("Player", player);
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
