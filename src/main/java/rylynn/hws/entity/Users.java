package rylynn.hws.entity;

import java.util.List;

public class Users {
    private List<User> user;

    public List<User> getUsers() {
        return user;
    }

    public void setUsers(List<User> user) {
        this.user = user;
    }

    public Users(List<User> user)
    {
        super();
        this.user = user;
    }

    public Users()
    {
        super();
    }
}
