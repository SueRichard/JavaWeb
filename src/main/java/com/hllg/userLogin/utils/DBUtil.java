package com.hllg.userLogin.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/02  Tue  22:18
 * 连接数据库的工具类
 */
public class DBUtil {
    private static Connection c;
    private static PreparedStatement p;
    private static ResultSet r;
    private static String user;
    private static String password;
    private static String url;
    private static String driverClass;
    private static DruidDataSource dataSource = new DruidDataSource();

    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("mysql");
        driverClass = resourceBundle.getString("driverClass");
        user = resourceBundle.getString("user");
        password = resourceBundle.getString("password");
        url = resourceBundle.getString("url");
        dataSource.setDriverClassName(driverClass);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setValidationQuery("select '1'");
    }

    public static Connection getConnection() {
        try {
            c = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return c;
    }

    public static PreparedStatement getPreparedStatement(String sql) {
        try {
            p = getConnection().prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return p;
    }

    public static void setParameters(List params) {
        if (params != null || params.size() > 0) {
            for (int i = 0; i < params.size(); i++) {
                try {
                    p.setObject(i + 1, params.get(i));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    public static int update(String sql, List params) {
        getPreparedStatement(sql);
        setParameters(params);
        try {
            return p.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public static ResultSet queryByCondition(String sql, List params) {
        getPreparedStatement(sql);
        setParameters(params);
        try {
            r = p.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }

    public static ResultSet queryAll(String sql) {
        getPreparedStatement(sql);
        try {
            r = p.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }

    public static void closeAll() {
        try {
            if (r != null) {
                r.close();
            }
            if (p != null) {
                p.close();
            }
            if (c != null) {
                c.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
