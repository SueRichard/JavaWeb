package com.hllg.curriculum.bean;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/09  Tue  20:21
 */
public class UserLikeCriticism implements Serializable {
    private static final long serialVersionUID = 4779383238650639175L;
    private int id;
    private int uid;
    private int cid;

    public UserLikeCriticism() {
    }

    public UserLikeCriticism(int id, int uid, int cid) {
        this.id = id;
        this.uid = uid;
        this.cid = cid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLikeCriticism that = (UserLikeCriticism) o;
        return id == that.id && uid == that.uid && cid == that.cid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, cid);
    }

    @Override
    public String toString() {
        return "UserLikeCriticism{" +
                "id=" + id +
                ", uid=" + uid +
                ", cid=" + cid +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
