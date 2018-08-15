package com.junfeng.user.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author junfeng
 * @Date 2018/8/3 20:39
 * Created by adminstor on 2018/8/3.
 */
@Setter
@Getter
@Entity
@Table(name = "t_users")
public class User {
    @GeneratedValue
    @Id
    private Integer uid;

    private String username;

    private String password;

    private String email;

    private String homeUrl;

    private String screenName;

    private double created;

    private double activated;

    private double logged;

    private String groupName;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeUrl() {
        return homeUrl;
    }

    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public double getCreated() {
        return created;
    }

    public void setCreated(double created) {
        this.created = created;
    }

    public double getActivated() {
        return activated;
    }

    public void setActivated(double activated) {
        this.activated = activated;
    }

    public double getLogged() {
        return logged;
    }

    public void setLogged(double logged) {
        this.logged = logged;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
