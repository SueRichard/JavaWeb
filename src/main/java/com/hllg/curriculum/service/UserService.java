package com.hllg.curriculum.service;

import com.hllg.curriculum.bean.User;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/08  Mon  19:28
 */
public interface UserService {
    User userLoginCheck(String name, String password);

    int updateUserCreditById(int id, int credit);

    int addUser(User user);

    boolean checkUserExistByUsername(String username);
}
