package com.hllg.curriculum.dao.impl;

import com.hllg.curriculum.bean.UserLikeCriticism;
import com.hllg.curriculum.dao.UserLikeCriticismDao;
import com.hllg.curriculum.utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/09  Tue  20:44
 */
public class UserLikeCriticismDaoImpl implements UserLikeCriticismDao {
    @Override
    public List<UserLikeCriticism> findAllLikes() {
        String sql = " select * from userLikeCriticism";
        List<UserLikeCriticism> likes = new ArrayList<>();
        ResultSet resultSet = DBUtil.queryAll(sql);
        try {
            while (resultSet.next()) {
                UserLikeCriticism like = new UserLikeCriticism();
                like.setId(resultSet.getInt("id"));
                like.setUid(resultSet.getInt("uid"));
                like.setCid(resultSet.getInt("cid"));
                likes.add(like);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeAll();
        }
        return likes;
    }

    /**
     * 暂未使用，使用需修改
     *
     * @param cid
     * @return list
     * @Author HLLG
     * @Date 09/03/2021 21:56
     **/
    @Override
    public List<UserLikeCriticism> findAllLikesByCriticismId(int cid) {
        String sql = " select * from userLikeCriticism where cid=?";
        List<UserLikeCriticism> likes = new ArrayList<>();
        ResultSet resultSet = DBUtil.queryAll(sql);
        try {
            while (resultSet.next()) {
                UserLikeCriticism like = new UserLikeCriticism();
                like.setId(resultSet.getInt("id"));
                like.setUid(resultSet.getInt("uid"));
                like.setCid(resultSet.getInt("cid"));
                likes.add(like);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeAll();
        }
        return likes;
    }

    @Override
    public int addLike(int uid, int cid) {
        String sql = " insert userLikeCriticism(uid,cid) values(?,?)";
        List params = new LinkedList();
        params.add(uid);
        params.add(cid);
        int add = DBUtil.update(sql, params);
        DBUtil.closeAll();
        return add;
    }

    @Override
    public int deleteLike(int id) {
        String sql = " delete from userLikeCriticism where id=?";
        List params = new LinkedList();
        params.add(id);
        int delete = DBUtil.update(sql, params);
        DBUtil.closeAll();
        return delete;
    }
}
