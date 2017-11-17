package rylynn.hws.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rylynn.hws.dao.UserDao;
import rylynn.hws.entity.User;
import rylynn.hws.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public List<User> findOvertimeUser() {
        return null;
    }

    public void registerOvertime(String username ,String place) {
        User user = userDao.findByUsername(username);
        user.setStatus(1);
        userDao.updateUser(user);
    }

    public void registerUser(User user) {
        userDao.addUser(user);
    }

    public void updateUserInfo(User user) {
        userDao.updateUser(user);
    }

    public void refreshStatus() {

    }
}
