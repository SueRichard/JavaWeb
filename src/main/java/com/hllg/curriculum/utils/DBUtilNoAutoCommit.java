package com.hllg.curriculum.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/08  Mon  16:58
 */
public class DBUtilNoAutoCommit {
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

    public static Connection getNoAutoCommitConnection() {
        try {
            c = dataSource.getConnection();
            c.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return c;
    }

    public static void rollback() {
        try {
            c.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void commit() {
        try {
            c.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static PreparedStatement getNotCommitPreparedStatement(String sql) {
        try {
            p = getNoAutoCommitConnection().prepareStatement(sql);
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


    public static int noAutoCommitUpdate(String sql, List params) {
        getNotCommitPreparedStatement(sql);
        setParameters(params);
        try {
            return p.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }


    public static ResultSet noAutoCommitQueryByCondition(String sql, List params) {
        getNotCommitPreparedStatement(sql);
        setParameters(params);
        try {
            r = p.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return r;
    }


    public static ResultSet noAutoCommitQueryAll(String sql) {
        getNotCommitPreparedStatement(sql);
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
