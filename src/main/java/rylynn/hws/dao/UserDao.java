package rylynn.hws.dao;

import rylynn.hws.entity.User;

import java.util.List;

public interface UserDao {
    public void addUser(User newuser);

    public void updateUser(User user);

    public void deleteUser(String username);

    public User findByAccount(String account);

    public List<User> findAllUser();
}
