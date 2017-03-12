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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/ajax")
public class Inventory {
    @Autowired
    private HttpServletRequest req;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ItemDAO itemDAO;

    @Autowired
    private UserDetailsDAO userDetailsDAO;

    @RequestMapping(value = "/strength", method = RequestMethod.GET)
    @ResponseBody
    public String strenght() {
        String name = (String) req.getSession().getAttribute("name");
        User bylogin = userDAO.findBylogin(name);
        if (bylogin.getUserdetails().getPoint()<1) return "";
        bylogin.getUserdetails().setPoint(bylogin.getUserdetails().getPoint() - 1);
        bylogin.getUserdetails().setStrenght(bylogin.getUserdetails().getStrenght() + 1);
        userDetailsDAO.update(bylogin.getUserdetails());
        Player player = getPlayer(bylogin.getUserdetails().getType(),bylogin.getLogin(), bylogin.getUserdetails());
        player.addStrength(0);
        req.getSession().setAttribute("user", player);
        String answer = player.getAttack() +" " + player.getHealth();
        return answer;
    }
    @RequestMapping(value = "/intelligence", method = RequestMethod.GET)
    @ResponseBody
    public String intelligence() {
        String name = (String) req.getSession().getAttribute("name");
        User bylogin = userDAO.findBylogin(name);
        if (bylogin.getUserdetails().getPoint()<1) return "";
        bylogin.getUserdetails().setPoint(bylogin.getUserdetails().getPoint() - 1);
        bylogin.getUserdetails().setIntelligence(bylogin.getUserdetails().getIntelligence()+1);
        userDetailsDAO.update(bylogin.getUserdetails());
        Player player = getPlayer(bylogin.getUserdetails().getType(),bylogin.getLogin(), bylogin.getUserdetails());
        player.addIntelligence(0);
        req.getSession().setAttribute("user", player);
        String answer = player.getAttack()+" " + player.getMana();
        return answer;
    }
    @RequestMapping(value = "/vitality", method = RequestMethod.GET)
    @ResponseBody
    public String vitality() {
        String name = (String) req.getSession().getAttribute("name");
        User bylogin = userDAO.findBylogin(name);
        if (bylogin.getUserdetails().getPoint()<1) return "";
        bylogin.getUserdetails().setPoint(bylogin.getUserdetails().getPoint() - 1);
        bylogin.getUserdetails().setVitality(bylogin.getUserdetails().getVitality() + 1);
        userDetailsDAO.update(bylogin.getUserdetails());
        Player player = getPlayer(bylogin.getUserdetails().getType(),bylogin.getLogin(), bylogin.getUserdetails());
        player.addVitality(0);
        req.getSession().setAttribute("user", player);
        String answer = player.getAttack() +" " + player.getHealth();
        return answer;
    }
    @RequestMapping(value = "/agility", method = RequestMethod.GET)
    @ResponseBody
    public String agility() {
        String name = (String) req.getSession().getAttribute("name");
        User bylogin = userDAO.findBylogin(name);
        if (bylogin.getUserdetails().getPoint()<1) return "";
        bylogin.getUserdetails().setPoint(bylogin.getUserdetails().getPoint() - 1);
        bylogin.getUserdetails().setAgility(bylogin.getUserdetails().getAgility() + 1);
        userDetailsDAO.update(bylogin.getUserdetails());
        Player player = getPlayer(bylogin.getUserdetails().getType(),bylogin.getLogin(), bylogin.getUserdetails());
        player.addAgility(0);
        req.getSession().setAttribute("user", player);
        String answer = player.getAttack() +" " + player.getDefense();
        return answer;
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
            player = null;

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
                player.equip(item);
            };
        } catch (NullPointerException ex) {}
        try {
            String[] split = userdetails.getWearingItems().split(",");
            for (String s : split) {
                int id = new Integer(s);
                Item item = itemDAO.findById(id);
                player.addItem(item);
            };
        } catch (NullPointerException ex) {
            System.out.println("afa");
        }
        player.calculateItem(userdetails.getItems(),userdetails.getWearingItems());
        player.calculateAttack();
        player.calculateHealth();
        player.calculateMana();
        player.calculateDefense();
        return player;
    }

}
