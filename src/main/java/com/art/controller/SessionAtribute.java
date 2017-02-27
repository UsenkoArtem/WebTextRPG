package com.art.controller;

import com.art.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.Random;

@Controller
@SessionAttributes( "user")
public class SessionAtribute {
    @RequestMapping(value = "/session",method = RequestMethod.GET)
    public String startSession(HttpSession httpSession , ModelMap map){
        User user = new User();
        Random org = new Random();
        int w = org.nextInt();
        user.setPassword(String.valueOf(w));
        user.setLogin("Okey");
        user.setPassword("22");
        httpSession.setAttribute("user", user);
        map.put("user",user);
        return "home";
    }
}
