package com.art.controller.ajaxController.battle;

import com.art.character.Enemies.Enemy;
import com.art.character.Heroes.Player;
import com.art.classWrapper.Answer.Answer;
import com.art.classWrapper.EnemyBattle;
import com.art.dao.PlayerDAO;
import com.art.dao.UserDAO;
import com.art.init.EnemyConfig;
import com.art.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/battle/{location}/ajax/battle")

public class Battle {
    @Autowired
    private PlayerDAO playerDAO;
    @Autowired
    private HttpServletRequest req;
    @Autowired
    private UserDAO userDAO;
    private Player player = null;
    private Enemy enemy = null;
    private ApplicationContext applicationContext = new AnnotationConfigApplicationContext(EnemyConfig.class);

    private void attackToHead(Player player, Enemy enemy) {
      int playerAttack  = (int) (player.getAttack()*0.5+player.getAttack()*1.5*Math.random()*2);
      int enemyAttack = enemy.getAttack();
      this.player.setHealth(player.getHealth()-enemyAttack+player.getDefense());
      this.enemy.setHealth(enemy.getHealth()-playerAttack+enemy.getDefense());
    }

    @RequestMapping(value = "/head/{enemyType}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Answer headAttack(@PathVariable String enemyType, @RequestBody EnemyBattle enemyBattle, @PathVariable("location") String location) {
         enemy = (Enemy) applicationContext.getBean(enemyType);
        System.out.println(enemy);
        String name = (String) req.getSession().getAttribute("name");
        User bylogin = userDAO.findByLogin(name);
         player = playerDAO.getPlayer(bylogin.getUserdetails().getType(), bylogin.getLogin(), bylogin.getUserdetails());
         attackToHead(player,enemy);
         if (enemy.getHealth()<=0) {
          Victory(enemy.getLevel()*50, 20);
         }
        return new Answer(player.getHealth(), enemy.getHealth());
    }

    public void Victory(int exp, int money ){
        player.addExp(exp);
        player.addMoney(money);
    }
    @RequestMapping(value= "/body/{enemy}", method=RequestMethod.POST, produces ="application/json")
    @ResponseBody
    public String bodyAttack(@PathVariable String enemy , @RequestBody EnemyBattle enemyBattle){
        System.out.println(enemy+ " " + enemyBattle.getHealth());
        Enemy bean = (Enemy) applicationContext.getBean(enemy);
        System.out.println(bean.toString());

        return "11";
    }
}
