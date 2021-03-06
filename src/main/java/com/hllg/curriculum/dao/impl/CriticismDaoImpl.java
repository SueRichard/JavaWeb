package com.hllg.curriculum.dao.impl;

import com.hllg.curriculum.dao.CriticismDao;
import com.hllg.curriculum.model.Criticism;
import com.hllg.curriculum.utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/06  Sat  18:01
 */
public class CriticismDaoImpl implements CriticismDao {
    @Override
    public List<Criticism> queryByCurriculumId(int id) {
        List<Criticism> list = new ArrayList<>();
        String sql = " select * from criticism where curriculumId=?";
        List params = new ArrayList();
        params.add(id);
        ResultSet rs = DBUtil.queryByCondition(sql, params);
        try {
            while (rs.next()) {
                Criticism criticism = new Criticism();
                criticism.setId(rs.getInt("id"));
                criticism.setUserId(rs.getInt("userId"));
                criticism.setCurriculumId(rs.getInt("curriculumId"));
                criticism.setContent(rs.getString("content"));
                //同时获取时间和日期
                criticism.setTime(rs.getTimestamp("time"));
                list.add(criticism);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeAll();
        }
        return list;
    }

    @Override
    public int deleteById(int id) {
        String sql = "delete from criticism where id =?";
        List params = new ArrayList();
        params.add(id);
        int update = DBUtil.update(sql, params);
        DBUtil.closeAll();
        return update;
    }

    @Override
    public int add(Criticism criticism) {
        String sql = " insert into criticism(userId,curriculumId,content,time) values(?,?,?,?)";
        List params = new ArrayList();
        params.add(criticism.getUserId());
        params.add(criticism.getCurriculumId());
        params.add(criticism.getContent());
        params.add(criticism.getTime());
        int add = DBUtil.update(sql, params);
        DBUtil.closeAll();
        return add;
    }
}
