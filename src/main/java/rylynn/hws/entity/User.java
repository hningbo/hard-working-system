package rylynn.hws.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.annotation.Generated;

@Document
public class User {
    @Id
    private long id;

    @Field("name")
    private String name;

    @Field("password")
    private String password;

    @Field("homenum")
    private long homeNum;

    @Field("place")
    private String place;

    @Field("status")
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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
