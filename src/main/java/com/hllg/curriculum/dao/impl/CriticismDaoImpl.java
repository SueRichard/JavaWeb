package com.hllg.curriculum.dao.impl;

import com.hllg.curriculum.bean.Criticism;
import com.hllg.curriculum.dao.CriticismDao;
import com.hllg.curriculum.utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
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
        String sql = "select criticism.*,`user`.`name` userName from criticism inner join user on criticism.userId=user.id where criticism.curriculumId=?";
//        String sql = " select criticism.*,user.name userName,count(*) people  from criticism \n" +
//                " inner join user on criticism.userId=user.id  \n" +
//                " inner join userLikeCriticism on userLikeCriticism.cid=criticism.id \n" +
//                " group by cid \n" +
//                " having criticism.curriculumId=?";
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
                criticism.setUserName(rs.getString("userName"));
//                criticism.setPeopleNumber(rs.getInt("people"));
                criticism.setLikesNumber(rs.getInt("likesNumber"));
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

    @Override
    public int updateLikesNumberById(int id, int number) {
        String sql = " update criticism set likesNumber=likesNumber+? where id=?";
        List params = new LinkedList();
        params.add(number);
        params.add(id);
        int update = DBUtil.update(sql, params);
        DBUtil.closeAll();
        return update;
    }

    @Override
    public int getLikesNumberById(int id) {
        String sql = " select likesNumber from criticism where id=?";
        List params = new LinkedList();
        params.add(id);
        ResultSet rs = DBUtil.queryByCondition(sql, params);
        int number = 0;
        try {
            while (rs.next()) {
                number = rs.getInt("likesNumber");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeAll();
        }
        return number;
    }

}
