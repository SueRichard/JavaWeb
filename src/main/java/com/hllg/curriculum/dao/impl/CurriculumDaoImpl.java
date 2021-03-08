package com.hllg.curriculum.dao.impl;

import com.hllg.curriculum.dao.CurriculumDao;
import com.hllg.curriculum.bean.Curriculum;
import com.hllg.curriculum.utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/03  Wed  20:36
 */
public class CurriculumDaoImpl implements CurriculumDao {
    @Override
    public List<Curriculum> findAll() {
        String sql = "select * from curriculum";
        ResultSet r = DBUtil.queryAll(sql);
        List<Curriculum> list = new ArrayList<>();
        try {
            while (r.next()) {
                Curriculum c = new Curriculum();
                c.setId(r.getInt("id"));
                c.setName(r.getString("name"));
                c.setPrice(r.getFloat("price"));
                c.setInfo(r.getString("info"));
                c.setNum(r.getInt("num"));
                c.setPeriod(r.getInt("period"));
                c.setStartTime(r.getDate("startTime"));
                c.setEndTime(r.getDate("endTime"));
                list.add(c);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeAll();
        }
        return list;
    }

    @Override
    public int add(Curriculum c) {
        String sql = "insert curriculum(name,price,info,num,period,startTime,endTime) value(?,?,?,?,?,?,?)";
        List params = new ArrayList();
        params.add(c.getName());
        params.add(c.getPrice());
        params.add(c.getInfo());
        params.add(c.getNum());
        params.add(c.getPeriod());
        params.add(c.getStartTime());
        params.add(c.getEndTime());
        int update = DBUtil.update(sql, params);
        DBUtil.closeAll();
        return update;
    }

    @Override
    public int delete(int id) {
        String sql = "delete from curriculum where id=?";
        List params = new ArrayList();
        params.add(id);
        int delete = DBUtil.update(sql, params);
        DBUtil.closeAll();
        return delete;
    }

    @Override
    public int updateById(Curriculum c, int id) {
        String sql = "update curriculum set name=?,price=?,info=?,num=?,period=?,startTime=?,endTime=? where id=?";
        List params = new ArrayList();
        params.add(c.getName());
        params.add(c.getPrice());
        params.add(c.getInfo());
        params.add(c.getNum());
        params.add(c.getPeriod());
        params.add(c.getStartTime());
        params.add(c.getEndTime());
        params.add(id);
        int update = DBUtil.update(sql, params);
        DBUtil.closeAll();
        return update;
    }

    @Override
    public Curriculum queryById(int id) {
        String sql = "select * from curriculum where id=?;";
        List params = new ArrayList();
        params.add(id);
        ResultSet r = DBUtil.queryByCondition(sql, params);
        Curriculum c = new Curriculum();
        try {
            while (r.next()) {
                c.setId(r.getInt("id"));
                c.setName(r.getString("name"));
                c.setPrice(r.getFloat("price"));
                c.setInfo(r.getString("info"));
                c.setNum(r.getInt("num"));
                c.setPeriod(r.getInt("period"));
                c.setStartTime(r.getDate("startTime"));
                c.setEndTime(r.getDate("endTime"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeAll();
        }
        return c;
    }
}
