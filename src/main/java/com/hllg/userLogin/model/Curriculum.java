package com.hllg.userLogin.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/03  Wed  20:30
 */
public class Curriculum implements Serializable {
    private static final long serialVersionUID = 595886723033656341L;
    private int id;
    private String name;
    private float price;
    private String info;
    private int num;
    private int period;
    private Date startTime;
    private Date endTime;

    public Curriculum() {
    }

    public Curriculum(int id, String name, float price, String info, int num, int period, Date startTime, Date endTime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.info = info;
        this.num = num;
        this.period = period;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Curriculum(String name, float price, String info, int num, int period, Date startTime, Date endTime) {
        this.name = name;
        this.price = price;
        this.info = info;
        this.num = num;
        this.period = period;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", info='" + info + '\'' +
                ", num=" + num +
                ", period=" + period +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curriculum that = (Curriculum) o;
        return id == that.id && Float.compare(that.price, price) == 0 && num == that.num && period == that.period && Objects.equals(name, that.name) && Objects.equals(info, that.info) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, info, num, period, startTime, endTime);
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
