package com.art.dao;
import com.art.model.User;
import java.util.List;

public interface UserDAO {
    public List<User> getAll();
    public User findById(int id );
    public void addUser(User user);
    public void deleteUser(int id);
    public User findBylogin(String login);
    public User findByEmail(String email);
    public void Update(User user);
}
