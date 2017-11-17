package rylynn.hws.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import rylynn.hws.dao.UserDao;
import rylynn.hws.entity.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private MongoTemplate template;

    public void addUser(User newuser) {
        template.insert(newuser);
    }

    public void updateUser(User user) {

    }

    public void deleteUser(User user) {

    }

    public User findByUsername(String username) {

        return null;
    }

    public List<User> findAllUser() {
        return template.findAll(User.class);
    }
}
