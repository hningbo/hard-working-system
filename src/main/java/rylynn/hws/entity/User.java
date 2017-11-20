package rylynn.hws.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.annotation.Generated;

@Document
public class User{
    @Id
    private String id;

    @Field("account")
    private String account;

    @Field("name")
    private String name;

    @Field("unit")
    private int unit;

    @Field("password")
    private String password;

    @Field("homenum")
    private long homenum;

    @Field("place")
    private String place;

    @Field("status")
    private int status;

    @Field("grade")
    private int grade;

    public User()
    {
    }

    public User(String name, String account ,String password, int unit ,long homenum ,String place ,int grade ) {
        this.name = name;
        this.account = account;
        this.password = password;
        this.unit = unit;
        this.homenum = homenum;
        this.grade = grade;
        this.place = place;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public long getHomenum() {
        return homenum;
    }

    public void setHomenum(long homenum) {
        this.homenum = homenum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String toString()
    {
        return "Username is : " + this.name + ", home is " + this.homenum +", status is " + this.status + ", grade is " + this.grade;
    }


    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


}
