package com.art.controller.battle;

import com.art.character.Heroes.Player;
import com.art.Service.PlayerService;
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
    private final EnemyConfig enemyConfig;
    private final HttpServletRequest req;
    private final PlayerService playerService;

    @Autowired
    public Woodland(EnemyConfig enemyConfig, HttpServletRequest req, PlayerService playerService) {
        this.enemyConfig = enemyConfig;
        this.req = req;
        this.playerService = playerService;
    }

    @RequestMapping(value = "/bear", method = RequestMethod.GET)
    public String battleBear(ModelMap map) {

        String type = (String) req.getSession().getAttribute("type");
        Player player = playerService.playerGetType(type);
        if (player==null) return "redirect:/";

        map.put("Player", player);
        map.put("Bear", enemyConfig.bear());
        return "/battle/woodland/BattleBear";
    }

    @RequestMapping(value = "/wolf", method = RequestMethod.GET)
    public String battleWolf(ModelMap map) {

        String type = (String) req.getSession().getAttribute("type");
        Player player = playerService.playerGetType(type);
        if (player==null) return "redirect:/";

        map.put("Player", player);
        map.put("Wolf", enemyConfig.wolf());
        return "/battle/woodland/BattleWolf";
    }

    @RequestMapping(value = "/marauder", method = RequestMethod.GET)
    public String battleMarauder(ModelMap map) {

        String type = (String) req.getSession().getAttribute("type");
        Player player = playerService.playerGetType(type);
        if (player==null) return "redirect:/";

        map.put("Player", player);
        map.put("Marauder", enemyConfig.marauder());
        return "/battle/woodland/BattleMarauder";
    }
}
