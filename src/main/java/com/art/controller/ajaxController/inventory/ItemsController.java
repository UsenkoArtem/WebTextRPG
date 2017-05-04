package com.art.controller.ajaxController.inventory;

import com.art.Service.PlayerService;
import com.art.character.Heroes.Player;
import com.art.dao.UserDAO;
import com.art.model.User;
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
    private final HttpServletRequest req;
    private final UserDAO userDAO;
    private final PlayerService playerService;

    @Autowired
    public ItemsController(HttpServletRequest req, UserDAO userDAO, PlayerService playerService) {
        this.req = req;
        this.userDAO = userDAO;
        this.playerService = playerService;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable int id) {
        String name = (String) req.getSession().getAttribute("name");
        if (name == null ) return "redirect:/";
        User bylogin = userDAO.findByLogin(name);
        Player player = playerService.getPlayer(bylogin.getUserdetails().getType(), bylogin.getLogin(), bylogin.getUserdetails());
        playerService.deleteItem(player, bylogin, id);
        req.getSession().setAttribute("user", player);
        return "okey";
    }

    @RequestMapping(value = "/unequipe/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String unequipe(@PathVariable int id) {
        String name = (String) req.getSession().getAttribute("name");
        if (name == null ) return "redirect:/";
        User bylogin = userDAO.findByLogin(name);
        Player player = playerService.getPlayer(bylogin.getUserdetails().getType(), bylogin.getLogin(), bylogin.getUserdetails());
         player = playerService.unequipe(player, bylogin, id);
        req.getSession().setAttribute("user", player);
        return player.statsString();
    }

    @RequestMapping(value = "/deleteEquipItem/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String deleteEquipeItem(@PathVariable int id) {
        String name = (String) req.getSession().getAttribute("name");
        if (name == null ) return "redirect:/";
        User bylogin = userDAO.findByLogin(name);
        Player player = playerService.getPlayer(bylogin.getUserdetails().getType(), bylogin.getLogin(), bylogin.getUserdetails());
        player = playerService.deleteEquipeItem(player, bylogin, id);
        req.getSession().setAttribute("user", player);
        return player.statsString();
    }

    @RequestMapping(value = "/equipItem/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String equipItem(@PathVariable int id) {
        String name  = (String) req.getSession().getAttribute("name");
        if (name == null ) return "redirect:/";
        User bylogin = userDAO.findByLogin(name);
        Player player = playerService.getPlayer(bylogin.getUserdetails().getType(),bylogin.getLogin(),bylogin.getUserdetails());
        player = playerService.equip(player,bylogin,id);
        req.getSession().setAttribute("user",player);
        return  player.statsString();

    }

}
