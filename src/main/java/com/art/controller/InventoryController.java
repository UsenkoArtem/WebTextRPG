package com.art.controller;

import com.art.character.Heroes.Mage;
import com.art.character.Heroes.Player;
import com.art.character.Heroes.Rogue;
import com.art.character.Heroes.Warrior;
import com.art.dao.PlayerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@ComponentScan({"com.art"})
public class InventoryController {
    @Autowired
    PlayerDAO playerDAO;
    @Autowired
    private HttpServletRequest req;

    @RequestMapping(value = "/inventory", method = RequestMethod.GET)
    public String inventory(ModelMap map) {
        String name  = (String) req.getSession().getAttribute("name");
        if (name == null ) return "redirect:/";
        String type = (String) req.getSession().getAttribute("type");
        Player player;
        if (type.equals("Warrior")) {
            player = (Warrior) req.getSession().getAttribute("user");

        } else if (type.equals("Rogue")) {
            player = (Rogue) req.getSession().getAttribute("user");
            ;

        } else if (type.equals("Mage")) {
            player = (Mage) req.getSession().getAttribute("user");
            ;

        } else {
            player = null;

        }

        map.put("Player", player);
        map.put("item", playerDAO.getWearItem(player));
        map.put("items", playerDAO.getItem(player));
        return "Inventory";
    }

}
