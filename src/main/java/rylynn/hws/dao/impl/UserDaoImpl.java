package rylynn.hws.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import rylynn.hws.dao.UserDao;
import rylynn.hws.entity.User;

import javax.xml.transform.Templates;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private MongoTemplate template;

    public void addUser(User newuser) {
        template.insert(newuser);
    }

    public void updateUser(User user) {
        Query query = Query.query(Criteria.where("name").is(user.getName()));
        Update update = Update.update("password", user.getPassword()).set("homenum", user.getHomenum()).
                set("grade" ,user.getGrade()).set("status" ,user.getStatus()).set("place" ,user.getPlace());
        template.updateFirst(query ,update ,User.class);
    }

    public void deleteUser(String username) {
        Query query = Query.query(Criteria.where("name").is(username));
        template.remove(query ,User.class);
    }

    public User findByAccount(String account) {

        return template.findOne(new Query(where("account").is(account)), User.class);
    }

    public List<User> findAllUser() {
        List<User> users = template.findAll(User.class);
        return users;
    }
}
