package com.hllg.curriculum.bean;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/02  Tue  20:36
 */
public class User implements Serializable {
    private static final long serialVersionUID = 5205895728967045112L;
    private int id;
    private String name;
    private String password;
    int role;
    private int credit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && role == user.role && credit == user.credit && Objects.equals(name, user.name) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, role, credit);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", credit=" + credit +
                '}';
    }

    public User() {
    }

    public User(int id, String name, String password, int role, int credit) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.credit = credit;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

}
