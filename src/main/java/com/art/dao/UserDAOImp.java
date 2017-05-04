package com.art.dao;

import com.art.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("UserDao")
@Transactional
@EnableTransactionManagement

public class UserDAOImp implements  UserDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAOImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAll() {
        return (List<User>) getSession().createCriteria(User.class).list();
    }

    @Override
    public User findById(int id) {
        return (User) getSession().get(User.class, id);

    }
    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void deleteUser(int id) {
        getSession().delete(findById(id));


    }
    @Override
    public User findByLogin(String login) {
        if (login.isEmpty()) return  null;
        Criteria criteria = getSession().createCriteria(User.class)
                .add(Restrictions.eq("login", login));
        User user;
        try {
            user = (User) criteria.list().get(0);
        } catch (Exception ex) {
            user = null;
        }

        return  user;
    }
    @Override
    public User findByEmail(String email) {
        if (email.isEmpty()) return  null;
        Criteria criteria = getSession().createCriteria(User.class)
                .add(Restrictions.eq("email", email));

        User user;
        try {
            user = (User) criteria.list().get(0);
        } catch (Exception e ) {
            user = null;
        }
        return  user;
    }
    @Override
    public  void update(User user) {
        getSession().update(user);
    }

    @Override
    public int count() {
        return  getSession().createCriteria(User.class).list().size();
    }

}
