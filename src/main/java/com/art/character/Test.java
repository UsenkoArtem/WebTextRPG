package com.art.character;

import com.art.dao.UserDAO;
import com.art.dao.UserDAOImp;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Test {
    @Autowired
    private UserDAO userDAO = new UserDAOImp();

    public static void main(String[] args) {
      List<Integer> integerList = new ArrayList<>();
      integerList.add(1);
      integerList.add(1);
      integerList.add(1);
      integerList.add(1);
      integerList.add(2);
        System.out.println(integerList.toArray().toString());
        integerList.remove(1);
        for (Integer integer : integerList) System.out.println(integer+" " );
        System.out.println(integerList.toArray().toString());

    }
}
