package com.hllg.curriculum.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/06  Sat  17:58
 */
public class Criticism implements Serializable {
    private static final long serialVersionUID = -6659165293252818230L;
    private int id;
    private int userId;
    private int curriculumId;
    private String content;
    private Date time;
    private String userName;
    private int peopleNumber;
    private int likesNumber;

    public Criticism() {
    }

    public Criticism(int userId, int curriculumId, String content, Date time) {
        this.userId = userId;
        this.curriculumId = curriculumId;
        this.content = content;
        this.time = time;
    }

    public Criticism(int id, int userId, int curriculumId, String content, Date time) {
        this.id = id;
        this.userId = userId;
        this.curriculumId = curriculumId;
        this.content = content;
        this.time = time;
    }

    public int getLikesNumber() {
        return likesNumber;
    }

    public void setLikesNumber(int likesNumber) {
        this.likesNumber = likesNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Criticism criticism = (Criticism) o;
        return id == criticism.id && userId == criticism.userId && curriculumId == criticism.curriculumId && Objects.equals(content, criticism.content) && Objects.equals(time, criticism.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, curriculumId, content, time);
    }

    @Override
    public String toString() {
        return "Criticism{" +
                "id=" + id +
                ", userId=" + userId +
                ", curriculumId=" + curriculumId +
                ", content='" + content + '\'' +
                ", time=" + time +
                '}';
    }

    public int getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(int peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(int curriculumId) {
        this.curriculumId = curriculumId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
