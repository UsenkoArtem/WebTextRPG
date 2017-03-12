package com.art.controller;

import com.art.character.Heroes.Mage;
import com.art.character.Heroes.Player;
import com.art.character.Heroes.Rogue;
import com.art.character.Heroes.Warrior;
import com.art.model.Item;
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
    private HttpServletRequest req;
    @RequestMapping(value = "/inventory",method = RequestMethod.GET)
    public  String inventory(ModelMap map) {

        String type = (String) req.getSession().getAttribute("type");
        Player player;
        if (type.equals("Warrior")) {
            player = (Warrior) req.getSession().getAttribute("user");

        } else if (type.equals("Rogue")) {
            player = (Rogue ) req.getSession().getAttribute("user");;

        } else if (type.equals("Mage")) {
            player = (Mage) req.getSession().getAttribute("user");;

        } else {
            player = null;

        }

        map.put("Player",player);
        int col = 0;
        for (Item item : player.getWearItem()){
            if (item!=null) {
                ++col;
            }
        }
        Item[] list = new Item[col];
        col=0;
        for (Item item : player.getWearItem()){
            if (item!=null) {
              list[col] = item; ++col;
            }
        }

        map.put("item",list);
        return "Inventory";
    }

}
