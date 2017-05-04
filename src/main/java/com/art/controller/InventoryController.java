package com.art.controller;

import com.art.character.Heroes.Player;
import com.art.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@ComponentScan({"com.art.dao"})
public class InventoryController {
    private final PlayerService playerService;
    private final HttpServletRequest req;

    @Autowired
    public InventoryController(PlayerService playerService, HttpServletRequest req) {
        this.playerService = playerService;
        this.req = req;
    }

    @RequestMapping(value = "/inventory", method = RequestMethod.GET)
    public String inventory(ModelMap map) throws ClassNotFoundException {

        String name = (String) req.getSession().getAttribute("name");
        if (name == null) return "redirect:/";
        String type = (String) req.getSession().getAttribute("type");
        Player player = playerService.playerGetType(type);

        map.put("item", playerService.getWearItem(player));
        map.put("items", playerService.getItem(player));

        map.put("Player", player);
        return "Inventory";
    }
}
