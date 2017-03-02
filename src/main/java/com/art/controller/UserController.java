package com.art.controller;

import com.art.character.Heroes.Mage;
import com.art.character.Heroes.Player;
import com.art.character.Heroes.Rogue;
import com.art.character.Heroes.Warrior;
import com.art.classWrapper.Registration;
import com.art.classWrapper.SignIn;
import com.art.dao.UserDAO;
import com.art.model.User;
import com.art.validation.RegValidation;
import com.art.validation.SignInValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;

@ComponentScan({"com.art"})
@Controller
@EnableWebMvc
@EnableTransactionManagement
@Transactional
public class UserController {

    @Autowired
    private HttpServletRequest req;

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
        return "signIn";
    }


    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String sigIn(ModelMap map, @ModelAttribute SignIn signIn, BindingResult result) {
        if (req.getSession().getAttribute("name") != null) return "redirect:index";
        signInValidation.validate(signIn, result);
        if (result.hasErrors()) {
            return "signIn";
        }
        User user = userDAO.findBylogin(signIn.getLogin());
        Player player;
        if (user.getType().equals("Warrior")) {
            player = new Warrior(user.getLogin());

        } else if (user.getType().equals("Rogue")) {
            player = new Rogue(user.getLogin());

        } else if (user.getType().equals("Mage")) {
            player = new Mage(user.getLogin());

        } else {
            player = null;

        }
        req.getSession().setAttribute("name", player.getName());
        req.getSession().setAttribute("type", player.getClass().getSimpleName());
        req.getSession().setAttribute("user", player);

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
        User user = new User();
        user.setPassword(registration.getPassword());
        user.setLogin(registration.getLogin());
        user.setEmail(registration.getEmail());
        user.setLevel(1);
        if (registration.getClassName().isEmpty()) registration.setClassName("Warrior");
        user.setType(registration.getClassName());
        userDAO.addUser(user);
        return "redirect:/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String start(ModelMap map) {
        return "index";
    }

}
