package com.hllg.userLogin.dao;

import com.hllg.userLogin.model.User;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/03  Wed  00:13
 */
public interface UserDao {
    User userLoginCheck(String name,String password);
}
