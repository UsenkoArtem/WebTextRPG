package com.art.dao;


import com.art.model.Item;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Repository("ItemDAO")
@Transactional
@EnableTransactionManagement
public class ItemDAOImp implements ItemDAO {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public Item findById(int id) {
            return (Item) sessionFactory.getCurrentSession().get(Item.class, id);
    }
}
