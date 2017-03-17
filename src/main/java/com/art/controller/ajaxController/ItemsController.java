package com.art.controller.ajaxController;

import com.art.character.Heroes.Player;
import com.art.dao.PlayerDAO;
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
    @Autowired
    private HttpServletRequest req;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PlayerDAO playerDAO;

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable int id) {
        String name = (String) req.getSession().getAttribute("name");
        User bylogin = userDAO.findBylogin(name);
        Player player = playerDAO.getPlayer(bylogin.getUserdetails().getType(), bylogin.getLogin(), bylogin.getUserdetails());
        playerDAO.deleteItem(player, bylogin, id);
        req.getSession().setAttribute("user", player);
        return "okey";
    }

    @RequestMapping(value = "/unequipe/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String unequipe(@PathVariable int id) {
        String name = (String) req.getSession().getAttribute("name");
        User bylogin = userDAO.findBylogin(name);
        Player player = playerDAO.getPlayer(bylogin.getUserdetails().getType(), bylogin.getLogin(), bylogin.getUserdetails());
        Player player1 = playerDAO.unequipe(player, bylogin, id);
        req.getSession().setAttribute("user", player);
        return player.statsString();
    }

    @RequestMapping(value = "/deleteEquipeItem/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String deleteEquipeItem(@PathVariable int id) {
        String name = (String) req.getSession().getAttribute("name");
        User bylogin = userDAO.findBylogin(name);
        Player player = playerDAO.getPlayer(bylogin.getUserdetails().getType(), bylogin.getLogin(), bylogin.getUserdetails());
        player = playerDAO.deleteEquipeItem(player, bylogin, id);
        req.getSession().setAttribute("user", player);
        return player.statsString();
    }
}
