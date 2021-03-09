package com.hllg.curriculum.dao.impl;

import com.hllg.curriculum.bean.User;
import com.hllg.curriculum.dao.UserDao;
import com.hllg.curriculum.utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/03  Wed  00:14
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User userLoginCheck(String name, String password) {
        String sql = "select * from user where name=? and password=?";
        List params = new ArrayList();
        params.add(name);
        params.add(password);
        User u = new User();
        ResultSet resultSet = DBUtil.queryByCondition(sql, params);
        try {
            while (resultSet.next()) {
                //未考虑用户名和密码都一致的情况，可以注册时让用户名唯一避免此检查
                u.setId(resultSet.getInt("id"));
                u.setName(resultSet.getString("name"));
                u.setPassword(resultSet.getString("password"));
                u.setRole(resultSet.getInt("role"));
                u.setCredit(resultSet.getInt("credit"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeAll();
        }
        return u;
    }


    @Override
    public int updateUserCreditById(int id, int credit) {
        if (credit < 0) {
            String query = "select credit from user where id=?";
            List param = new ArrayList();
            param.add(id);
            ResultSet resultSet = DBUtil.queryByCondition(query, param);
            int resultNumber = 0;
            try {
                while (resultSet.next()) {
                    resultNumber = resultSet.getInt("credit");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                DBUtil.closeAll();
            }
            if (resultNumber - 100 >= 0) {
                String sql = "update user set credit=credit+? where id=?";
                List params = new LinkedList();
                params.add(credit);
                params.add(id);
                int update = DBUtil.update(sql, params);
                DBUtil.closeAll();
                return update;
            }
            return 0;
        } else {
            String sql = "update user set credit=credit+? where id=?";
            List params = new LinkedList();
            params.add(credit);
            params.add(id);
            int update = DBUtil.update(sql, params);
            DBUtil.closeAll();
            return update;
        }
    }

    /**
     * 暂时只加入了用户的密码和用户名，后续请再更改sql语句
     *
     * @param user
     * @return int
     * @Author HLLG
     * @Date 09/03/2021 16:12
     **/
    @Override
    public int addUser(User user) {
        String sql = "insert into user(name,password) values(?,?);";
        List params = new LinkedList();
        params.add(user.getName());
        params.add(user.getPassword());
        int add = DBUtil.update(sql, params);
        DBUtil.closeAll();
        return add;
    }

    @Override
    public boolean checkUserExistByUsername(String username) {
        String sql = "select count(*) num from user where name=?";
        List params = new LinkedList();
        params.add(username);
        ResultSet resultSet = DBUtil.queryByCondition(sql, params);
        boolean isExist = false;
        int num;
        try {
//            //到最后一行
//            resultSet.last();
//            //获取总行数
//            int row = resultSet.getRow();
            resultSet.next();
            num = resultSet.getInt("num");
            if (num > 0) {
                isExist = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return isExist;
    }
}
