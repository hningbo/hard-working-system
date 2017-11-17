package rylynn.hws.entity;

public class User {
    private String name;
    private String password;
    private long homeNum;
    private int status;

    public User()
    {
        super();
    }

    public User(String name, String password, long homeNum) {
        this.name = name;
        this.password = password;
        this.homeNum = homeNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getHomeNum() {
        return homeNum;
    }

    public void setHomeNum(long homeNum) {
        this.homeNum = homeNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
