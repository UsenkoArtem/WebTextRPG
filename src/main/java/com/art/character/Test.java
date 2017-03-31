package com.art.character;

import com.art.dao.UserDAO;
import com.art.dao.UserDAOImp;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Test {
    @Autowired
    private UserDAO userDAO = new UserDAOImp();

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.art.character.Enemies.Woodland.Bear");
        Field[] declaredFields = aClass.getFields();
        System.out.println(Arrays.toString(declaredFields));


    }
}
