package rylynn.hws.service;

import rylynn.hws.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findOvertimeUser();

    /*
    after 10:25 registerovertime is forbidden...
     */
    public void registerOvertime(String username);

    public void registerUser(User user);

    public void updateUserInfo(User user);

}
