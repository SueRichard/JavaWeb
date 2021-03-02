package com.hllg.userLogin.dao.impl;

import com.hllg.userLogin.dao.UserDao;
import com.hllg.userLogin.model.User;
import com.hllg.userLogin.utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeAll();
        }
        return u;
    }
}
