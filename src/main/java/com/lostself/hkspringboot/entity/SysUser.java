package com.lostself.hkspringboot.entity;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.io.Serializable;

public class SysUser implements Serializable {

    public SysUser() {
    }

    public SysUser(Integer id, String usercode, String username, String password, String salt, String locked) {
        this.id = id;
        this.usercode = usercode;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.locked = locked;
    }

    private Integer id;

    private String usercode;

    private String username;

    private String password;

    private String salt;

    private String locked;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }
}