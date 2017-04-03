package com.art.controller.ajaxController.battle;

import com.art.character.Enemies.Enemy;
import com.art.classWrapper.EnemyBattle;
import com.art.init.EnemyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/battle/woodland/ajax/battle")
public class Battle {
    private ApplicationContext applicationContext = new AnnotationConfigApplicationContext(EnemyConfig.class);
    @RequestMapping(value = "/head/{enemy}",method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String headAttack(@PathVariable String enemy , @RequestBody EnemyBattle enemyBattle){
        System.out.println(enemy+ " " + enemyBattle.getHealth());
            Enemy bean = (Enemy) applicationContext.getBean(enemy);
            System.out.println(bean.toString());

        return "11";
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
