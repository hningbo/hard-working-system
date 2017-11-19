package rylynn.hws.dao;

import rylynn.hws.entity.User;

import java.util.List;

public interface UserDao {
    public void addUser(User newuser);

    public void updateUser(User user);

    public void deleteUser(String username);

    public User findByUsername(String username);

    public List<User> findAllUser();
}
