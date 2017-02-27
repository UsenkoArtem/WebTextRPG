
package com.art.controller;

import com.art.validation.RegValidation;
import com.art.validation.SignInValidation;
import com.art.character.Mage;
import com.art.character.Player;
import com.art.character.Rogue;
import com.art.character.Warrior;
import com.art.classWrapper.Registration;
import com.art.classWrapper.SignIn;
import com.art.dao.UserDAO;
import com.art.model.User;
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
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public  String index (ModelMap map) {
        map.put("signIn", new SignIn());
        return "SignIn";
    }
    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public  String reg (ModelMap map ) {
        map.put("registration",new Registration());
        return "registration";
    }
    @RequestMapping(value = "/registration",method = RequestMethod.POST)
    public  String newUser(ModelMap map , @ModelAttribute Registration registration , BindingResult result) {
        regValidation.validate(registration,result);
        if (result.hasErrors()) return "registration";
        User user = new User();
        user.setPassword(registration.getPassword());
        user.setLogin(registration.getLogin());
        user.setEmail(registration.getEmail());
        user.setLevel(1);
        if (registration.getClassName().isEmpty()) registration.setClassName("Warrior");
        user.setType(registration.getClassName());
        userDAO.addUser(user);
        return "index";
    }
    @RequestMapping(value = "/SignIn",method = RequestMethod.POST)
    public  String sigIn(ModelMap map , @ModelAttribute SignIn signIn, BindingResult result) {
        signInValidation.validate(signIn, result);
        if (result.hasErrors()) {
            return "SignIn";
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
        req.getSession().setAttribute("name",player.getName());
        req.getSession().setAttribute("type",player.getClass().getSimpleName());
        req.getSession().setAttribute("user",player);
        return "write";
    }

    @RequestMapping(value = "/1",method = RequestMethod.GET)
    public  String write(ModelMap map) {
        System.out.println(req.getSession().getAttribute("name"));
        String name = req.getSession().getAttribute("type").toString();
        Player player;
        if (name.equals("Warrior")) {
            player = (Warrior) req.getSession().getAttribute("user");

        } else if (name.equals("Rogue")) {
            player = (Rogue) req.getSession().getAttribute("user");

        } else if (name.equals("Mage")) {
            player = (Mage) req.getSession().getAttribute("user");

        } else {
            player = null;

        }

        map.put("user",player.toString());
        return  "write";
    }

}
