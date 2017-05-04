package com.art.controller.ajaxController.battle;

import com.art.Service.PlayerService;
import com.art.character.Enemies.Enemy;
import com.art.character.Heroes.Player;
import com.art.classWrapper.Answer.Answer;
import com.art.dao.UserDAO;
import com.art.dao.UserDetailsDAO;
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
    private final UserDetailsDAO userDetailsDAO;
    private final PlayerService playerService;
    private final HttpServletRequest req;
    private final UserDAO userDAO;
    private Player player = null;
    private Enemy enemy = null;
    private ApplicationContext applicationContext = new AnnotationConfigApplicationContext(EnemyConfig.class);

    @Autowired
    public Battle(PlayerService playerService, HttpServletRequest req, UserDAO userDAO, UserDetailsDAO userDetailsDAO) {
        this.playerService = playerService;
        this.req = req;
        this.userDAO = userDAO;
        this.userDetailsDAO = userDetailsDAO;
    }

    private void attackToHead(Player player, Enemy enemy) {
        int playerAttack = (int) (player.getAttack() * 0.5 + player.getAttack() * 1.5 * ((int) (Math.random() * 6) / 6));
        int enemyAttack = enemy.getAttack();
        this.player.setHealth((int) (player.getHealth() - enemyAttack + enemyAttack * (((0.06 * player.getDefense()) / (1 + 0.06 * player.getDefense())))));
        this.enemy.setHealth((int) (enemy.getHealth() - playerAttack + playerAttack * (((0.06 * enemy.getDefense()) / (1 + 0.06 * enemy.getDefense())))));
    }

    private void attackToBody(Player player, Enemy enemy) {
        int playerAttack = (int) (player.getAttack() * 0.5 + player.getAttack() * Math.random() * 4);
        int enemyAttack = enemy.getAttack();
        this.player.setHealth((int) (player.getHealth() - enemyAttack + enemyAttack * (((0.06 * player.getDefense()) / (1 + 0.06 * player.getDefense())))));
        this.enemy.setHealth((int) (enemy.getHealth() - playerAttack + playerAttack * (((0.06 * enemy.getDefense()) / (1 + 0.06 * enemy.getDefense())))));

    }

    private void attackToLegs(Player player, Enemy enemy) {
        int playerAttack = (int) (player.getAttack() * 0.5 + player.getAttack() * Math.random() * 3);
        int enemyAttack = enemy.getAttack();
        this.player.setHealth((int) (player.getHealth() - enemyAttack + enemyAttack * (((0.06 * player.getDefense()) / (1 + 0.06 * player.getDefense())))));
        this.enemy.setHealth((int) (enemy.getHealth() - playerAttack + playerAttack * (((0.06 * enemy.getDefense()) / (1 + 0.06 * enemy.getDefense())))));

    }

    @RequestMapping(value = "/head/{enemyType}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Answer headAttack(@PathVariable String enemyType, @RequestBody Answer battle, @PathVariable("location") String location) {
        enemy = (Enemy) applicationContext.getBean(enemyType);
        enemy.setHealth(battle.getEnemyHealth());
        String name = (String) req.getSession().getAttribute("name");
        User bylogin = userDAO.findByLogin(name);
        player = playerService.getPlayer(bylogin.getUserdetails().getType(), bylogin.getLogin(), bylogin.getUserdetails());
        int health = player.getHealth();
        player.setHealth(battle.getPlayerHealth());
        attackToHead(player, enemy);
        if (enemy.getHealth() <= 0) {
            player.setHealth(health);
            victory(enemy.getLevel() * 50, 20, bylogin);
        }
        return new Answer(player.getHealth(), enemy.getHealth(), location);
    }


    @RequestMapping(value = "/body/{enemyType}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Answer bodyAttack(@PathVariable String enemyType, @RequestBody Answer battle, @PathVariable("location") String location) {
        enemy = (Enemy) applicationContext.getBean(enemyType);
        enemy.setHealth(battle.getEnemyHealth());
        String name = (String) req.getSession().getAttribute("name");
        User bylogin = userDAO.findByLogin(name);
        player = playerService.getPlayer(bylogin.getUserdetails().getType(), bylogin.getLogin(), bylogin.getUserdetails());
        int health = player.getHealth();
        player.setHealth(battle.getPlayerHealth());
        attackToBody(player, enemy);
        if (enemy.getHealth() <= 0) {
            player.setHealth(health);
            victory(enemy.getLevel() * 50, 20, bylogin);
        }
        return new Answer(player.getHealth(), enemy.getHealth(), location);
    }

    @RequestMapping(value = "/legs/{enemyType}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Answer legsAttack(@PathVariable String enemyType, @RequestBody Answer battle, @PathVariable("location") String location) {

        enemy = (Enemy) applicationContext.getBean(enemyType);
        enemy.setHealth(battle.getEnemyHealth());
        String name = (String) req.getSession().getAttribute("name");
        User bylogin = userDAO.findByLogin(name);
        player = playerService.getPlayer(bylogin.getUserdetails().getType(), bylogin.getLogin(), bylogin.getUserdetails());
        int health = player.getHealth();
        player.setHealth(battle.getPlayerHealth());
        attackToLegs(player, enemy);
        if (enemy.getHealth() <= 0) {
            player.setHealth(health);
            victory(enemy.getLevel() * 50, 20, bylogin);
        }
        return new Answer(player.getHealth(), enemy.getHealth(), location);
    }


    private void victory(int exp, int money, User bylogin) {
        player.addExp(exp);
        player.addMoney(money);
        bylogin.getUserdetails().setLevel(player.getLevel());
        bylogin.getUserdetails().setExp(player.getExp());
        System.out.println(player.getPoint());
        bylogin.getUserdetails().setPoint(player.getPoint());
        userDetailsDAO.update(bylogin.getUserdetails());
        req.getSession().setAttribute("user",player);
    }
}
