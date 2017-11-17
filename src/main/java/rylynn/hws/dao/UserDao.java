package rylynn.hws.dao;

import rylynn.hws.entity.User;

public interface UserDao {
    public void addUser(User newuser);

    public void updateUser(User user);

    public void deleteUser(User user);

    public void findByUsername(String username);
}
