package com.art.dao;

import com.art.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository("UserDao")
@Transactional
@EnableTransactionManagement
public class UserDAOImp implements  UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

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

        return (User) getSession().get(User.class,id);
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public void deleteUser(int id) {
        sessionFactory.getCurrentSession().createQuery("DELETE  from " +
                "User WHERE id= "+id).executeUpdate();

    }

    @Override
    public User findBylogin(String login) {
        if (login.isEmpty()) return  null;
        Query query = getSession().createQuery(" from User  where login= :login ");
        query.setString("login",login);
        User user;
        try {
             user = (User) query.uniqueResult();
        } catch (SQLGrammarException e ) {
            user = null;
        }
        return  user;
    }
    @Override
    public User findByEmail(String email) {
        if (email.isEmpty()) return  null;
        Query query = getSession().createQuery(" from User  where email= :email");
        query.setString("email",email);

        User user;
        try {
            user = (User) query.uniqueResult();
        } catch (SQLGrammarException e ) {
            user = null;
        }
        return  user;
    }
    @Override
    public  void Update(User user) {
        getSession().update(user);
    }

}
