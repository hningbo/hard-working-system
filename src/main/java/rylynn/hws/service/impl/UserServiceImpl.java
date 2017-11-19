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
        List<User> users = userDao.findAllUser();
        List<User> overTimeUser = null;
        for(User user : users)
        {
            if(user.getStatus() == 1)
            {
                overTimeUser.add(user);
            }
        }
        return overTimeUser;
    }

    public void registerOvertime(String username ,String place) {
        User user = (User) userDao.findByUsername(username);
        user.setStatus(1);
        userDao.updateUser(user);
    }

    public int registerUser(User user) {
        if(userDao.findByUsername(user.getName()) == null)
        {
            return 0;
        }
        userDao.addUser(user);
        return 1;
    }

    public void updateUserInfo(User user) {
        userDao.updateUser(user);
    }

    public void refreshStatus() {
        List<User> users = userDao.findAllUser();
        for(User user : users) {
            user.setStatus(0);
            userDao.updateUser(user);
        }
    }
}
