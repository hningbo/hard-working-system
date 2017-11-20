package rylynn.hws.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rylynn.hws.dao.UserDao;
import rylynn.hws.entity.User;
import rylynn.hws.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public List<User> findOvertimeUser() {
        List<User> users = userDao.findAllUser();
        List<User> overTimeUser = new ArrayList<User>();


        for(User user : users)
        {
            if(user.getStatus() == 1)
            {
                overTimeUser.add(user);
            }
        }
        return overTimeUser;
    }

    public void registerOvertime(String account ,String place) {
        User user = (User) userDao.findByAccount(account);
        user.setStatus(1);
        user.setPlace(place);
        userDao.updateUser(user);
    }

    public void giveupOvertime(String account)
    {
        User user = (User) userDao.findByAccount(account);
        user.setStatus(0);
        userDao.updateUser(user);
    }

    public int registerUser(User user) {
        if(userDao.findByAccount(user.getAccount()) != null)
        {
            return 0;
        }

        userDao.addUser(user);
        return 1;
    }

    public void updateUserInfo(User user) {
        userDao.updateUser(user);
    }

    public int userExist(String account) {
        if(userDao.findByAccount(account) == null)
        {
            return 0;
        }
        else
        {
            return 1;
        }

    }

    public int checkPassword(String username ,String password)
    {
        User user = (User)userDao.findByAccount(username);
        String pwd = user.getPassword();
        if(pwd.equals(password))
        {
            return 1;
        }
        return 0;
    }

    public void refreshStatus() {
        List<User> users = userDao.findAllUser();
        for(User user : users) {
            user.setStatus(0);
            userDao.updateUser(user);
        }
    }
}
