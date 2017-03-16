package com.art.controller.ajaxController;

import com.art.character.Heroes.Mage;
import com.art.character.Heroes.Player;
import com.art.character.Heroes.Rogue;
import com.art.character.Heroes.Warrior;
import com.art.dao.ItemDAO;
import com.art.dao.UserDAO;
import com.art.dao.UserDetailsDAO;
import com.art.model.Item;
import com.art.model.User;
import com.art.model.Userdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("ajax/item")
public class ItemsController {
    @Autowired
    private HttpServletRequest req;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ItemDAO itemDAO;

    @Autowired
    private UserDetailsDAO userDetailsDAO;

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable int id ) {
        String name = (String) req.getSession().getAttribute("name");
        User bylogin = userDAO.findBylogin(name);
        Player player  = getPlayer(bylogin.getUserdetails().getType(),bylogin.getLogin(),bylogin.getUserdetails());
        player.deleteItem(itemDAO.findById(id));
        String s = "";
        try {
        for (Item item : player.getItemList()) {
            if (item!=null) {
                if (s.equals("")) s+=item.getId(); else
             s=s+","+item.getId();
            }
        }  } catch ( Exception ex) {}
        if (s.isEmpty()) s=null;
        bylogin.getUserdetails().setItems(s);
        userDetailsDAO.update(bylogin.getUserdetails());
        req.getSession().setAttribute("name", player.getName());
        req.getSession().setAttribute("type", player.getClass().getSimpleName());
        req.getSession().setAttribute("user", player);
        return "okey";
    }
    @RequestMapping(value = "/unequipe/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String  unequipe(@PathVariable int id ) {
        String name = (String) req.getSession().getAttribute("name");
        User bylogin = userDAO.findBylogin(name);
        Player player  = getPlayer(bylogin.getUserdetails().getType(),bylogin.getLogin(),bylogin.getUserdetails());
        Item item1 = itemDAO.findById(id);
        System.out.println(bylogin.getUserdetails().getItems());
        for (Item item : player.getItemList())
            System.out.print(item.getId()+" ");
        System.out.println();
        player.unequip(item1);
        for (Item item : player.getItemList())
            System.out.print(item.getId()+" ");
        System.out.println();
        String s = "";
        try {
        for (Item item : player.getWearItem()) {
            if (item!=null) {
                if (s.equals("")) s+=item.getId(); else
                    s=s+","+item.getId();
            }
        }} catch (Exception ex) {}
        if (s.isEmpty()) s=null;
        bylogin.getUserdetails().setWearingItems(s);
        String items = bylogin.getUserdetails().getItems();
        System.out.println(items);
         try {
             items = items + ","+Integer.toString(id);
         } catch (NullPointerException ex) {
             items = new String();
             items = Integer.toString(id);
         }
        bylogin.getUserdetails().setItems(items);
        userDetailsDAO.update(bylogin.getUserdetails());
        req.getSession().setAttribute("name", player.getName());
        req.getSession().setAttribute("type", player.getClass().getSimpleName());
        req.getSession().setAttribute("user", player);
        for (Item item : player.getItemList())
            System.out.print(item.getId()+" ");
        System.out.println();
        return player.statsString();
    }

    @RequestMapping(value = "/deleteEquipeItem/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String  deleteEquipeItem(@PathVariable int id ) {
        String name = (String) req.getSession().getAttribute("name");
        User bylogin = userDAO.findBylogin(name);
        Player player  = getPlayer(bylogin.getUserdetails().getType(),bylogin.getLogin(),bylogin.getUserdetails());
        Item item1 = itemDAO.findById(id);
        System.out.println(bylogin.getUserdetails().getItems());
        player.unequip(item1);
        String s = "";
        try {
            for (Item item : player.getWearItem()) {
                if (item!=null) {
                    if (s.equals("")) s+=item.getId(); else
                        s=s+","+item.getId();
                }
            }} catch (Exception ex) {}
        if (s.isEmpty()) s=null;
        bylogin.getUserdetails().setWearingItems(s);
        player.deleteItem(item1);
        s = "";
        try {
            for (Item item : player.getItemList()) {
                if (item!=null) {
                    if (s.equals("")) s+=item.getId(); else
                        s=s+","+item.getId();
                }
            }  } catch ( Exception ex) {}
        if (s.isEmpty()) s=null;
        userDetailsDAO.update(bylogin.getUserdetails());
        req.getSession().setAttribute("name", player.getName());
        req.getSession().setAttribute("type", player.getClass().getSimpleName());
        req.getSession().setAttribute("user", player);
        return player.statsString();
    }
    private Player getPlayer(String type, String login, Userdetails userdetails) {
        Player player;
        if (type.equals("Warrior")) {
            player = new Warrior(login);

        } else if (type.equals("Rogue")) {
            player = new Rogue(login);

        } else if (type.equals("Mage")) {
            player = new Mage(login);

        } else {
            player =  null;;
        }
        if (userdetails.getAgility()!=0)   player.setAgility(userdetails.getAgility());
        if (userdetails.getStrenght()!=0)   player.setStrength(userdetails.getStrenght());
        if (userdetails.getIntelligence()!=0)player.setIntelligence(userdetails.getIntelligence());
        if (userdetails.getVitality()!=0) player.setVitality(userdetails.getVitality());
        if (userdetails.getExp()!=0) player.setExp(userdetails.getExp());
        player.setLevel(userdetails.getLevel());
        player.setPoint(userdetails.getPoint());
        try {
            String[] split = userdetails.getItems().split(",");
            for (String s : split) {
                int id = new Integer(s);
                Item item = itemDAO.findById(id);

                player.equip(item);;
            };
        } catch (NullPointerException ex) {}
        try {
            String[] split = userdetails.getWearingItems().split(",");
            for (String s : split) {
                int id = new Integer(s);
                Item item = itemDAO.findById(id);
                player.equip(item);
                player.addItem(item);
            };
        } catch (NullPointerException ex) {
            System.out.println("afa");;
        }
        player.calculateItem(userdetails.getItems(),userdetails.getWearingItems());
        player.calculateAttack();
        player.calculateHealth();
        player.calculateMana();
        player.calculateDefense();
        return player;
    }


}
