package com.art.character;

import com.art.character.Heroes.Mage;
import com.art.dao.UserDAO;
import com.art.dao.UserDAOImp;
import org.springframework.beans.factory.annotation.Autowired;

public class Test {
    @Autowired
    private UserDAO userDAO = new UserDAOImp();

    public static void main(String[] args) throws ClassNotFoundException {
        Mage mage = new Mage();
    }
}
