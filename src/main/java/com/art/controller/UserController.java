package com.art.controller;

import com.art.character.Heroes.Mage;
import com.art.character.Heroes.Player;
import com.art.character.Heroes.Rogue;
import com.art.character.Heroes.Warrior;
import com.art.classWrapper.Registration;
import com.art.classWrapper.SignIn;
import com.art.dao.ItemDAO;
import com.art.dao.UserDAO;
import com.art.model.Item;
import com.art.model.User;
import com.art.model.Userdetails;
import com.art.validation.RegValidation;
import com.art.validation.SignInValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@ComponentScan({"com.art"})
@Controller
public class UserController {

    private Player getPlayer(String type, String login, Userdetails userdetails) {
        Player player;
        if (type.equals("Warrior")) {
            player = new Warrior(login);

        } else if (type.equals("Rogue")) {
            player = new Rogue(login);

        } else if (type.equals("Mage")) {
            player = new Mage(login);

        } else {
            player = null;;;

        }
        if (userdetails.getAgility()!=0)   player.setAgility(userdetails.getAgility());
        if (userdetails.getStrenght()!=0)   player.setStrength(userdetails.getStrenght());
        if (userdetails.getIntelligence()!=0)player.setIntelligence(userdetails.getIntelligence());
        if (userdetails.getVitality()!=0) player.setVitality(userdetails.getVitality());
        if (userdetails.getExp()!=0) player.setExp(userdetails.getExp());
        player.setLevel(userdetails.getLevel());
        player.setPoint(userdetails.getPoint());
        try {
            String[] split = userdetails.getWearingItems().split(",");
            for (String s : split) {
                int id = new Integer(s);
                Item item = itemDAO.findById(id);
                player.addItem(item);

            };
        } catch (Exception ex) {

        }
         try {
             String[] split = userdetails.getItems().split(",");
             for (String s : split) {
                 int id = new Integer(s);
                 Item item = itemDAO.findById(id);
                 player.equip(item);;;
             };
         } catch (NullPointerException ex) {}

        player.calculateItem(userdetails.getItems(),userdetails.getWearingItems());
        player.calculateAttack();
        player.calculateHealth();
        player.calculateMana();
        player.calculateDefense();
        return player;
    }

    @Autowired
    private HttpServletRequest req;

    @Autowired
    private ItemDAO itemDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private SignInValidation signInValidation;

    @Autowired
    private RegValidation regValidation;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap map) {
        if (req.getSession().getAttribute("name") != null) return "redirect:index";
        map.put("signIn", new SignIn());
        return "SignIn";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String sigIn(ModelMap map, @ModelAttribute SignIn signIn, BindingResult result) {
        if (req.getSession().getAttribute("name") != null) return "redirect:index";
        signInValidation.validate(signIn, result);
        if (result.hasErrors()) {
            return "SignIn";
        }
        User user = userDAO.findBylogin(signIn.getLogin());
        Player player = getPlayer(user.getUserdetails().getType(),user.getLogin(), user.getUserdetails());
        req.getSession().setAttribute("name", player.getName());
        req.getSession().setAttribute("type", player.getClass().getSimpleName());
        req.getSession().setAttribute("user", player);
        System.out.println(player);
        return "redirect:/index";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String reg(ModelMap map) {
        map.put("registration", new Registration());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String newUser(ModelMap map, @ModelAttribute Registration registration, BindingResult result) {
        regValidation.validate(registration, result);
        if (result.hasErrors()) return "registration";
        User user = new User(registration.getLogin(),registration.getPassword(),registration.getEmail());
        Userdetails userdetails = new Userdetails();
        userdetails.setLevel(1);
        userdetails.setExp(0);
        userdetails.setPoint(0);
        userdetails.setAgility(0);
        userdetails.setVitality(0);
        userdetails.setIntelligence(0);
        userdetails.setStrenght(0);
        if (registration.getClassName().isEmpty()) registration.setClassName("Warrior");
        userdetails.setType(registration.getClassName());
        Player player = getPlayer(userdetails.getType(),user.getLogin(),userdetails);
        userdetails.setAgility(player.getAgility());
        userdetails.setStrenght(player.getStrength());
        userdetails.setIntelligence(player.getIntelligence());
        userdetails.setVitality(player.getVitality());
        user.setUserdetails(userdetails);
       // userdetails.setUserById(user);
        userDAO.addUser(user);
        req.getSession().setAttribute("name",user.getLogin());
        req.getSession().setAttribute("user", player);
        req.getSession().setAttribute("type",player.getClass().getSimpleName());
        return "redirect:/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String start(ModelMap map) {
        return "index";
    }

    @RequestMapping(value = "/exit",method = RequestMethod.GET)
    public  String exit(ModelMap map ) {
        req.getSession().removeAttribute("name");
        req.getSession().removeAttribute("user");
        req.getSession().removeAttribute("type");
        return  "redirect: /";
    }
   @RequestMapping(value = "/woodland",method = RequestMethod.GET)
    public  String woodland () {
        return "woodland";
   }
}
