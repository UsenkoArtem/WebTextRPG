package com.art.character;

import com.art.character.Heroes.Player;
import com.art.character.Heroes.Warrior;
import com.art.dao.UserDAO;
import com.art.dao.UserDAOImp;
import org.springframework.beans.factory.annotation.Autowired;

public class Test {
    @Autowired
    private UserDAO userDAO = new UserDAOImp();
    public  void main1() {
        System.out.print(userDAO.findById(1));
        Player player = new Warrior("faf");
        String s = new String("1,2,3");
        String[] split = s.split(",");
        for (String s1 : split) {
            int id = new Integer(s1);
            System.out.println(id);
        }
        int id = new Integer("1");
        player.calculateItem(null, "1,2,3");

        System.out.println(player);

    }
}
