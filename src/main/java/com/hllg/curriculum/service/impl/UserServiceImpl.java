package com.hllg.curriculum.service.impl;

import com.hllg.curriculum.dao.UserDao;
import com.hllg.curriculum.dao.impl.UserDaoImpl;
import com.hllg.curriculum.bean.User;
import com.hllg.curriculum.service.UserService;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/08  Mon  19:29
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User userLoginCheck(String name, String password) {
        return userDao.userLoginCheck(name, password);
    }

    @Override
    public int updateUserCreditById(int id, int credit) {
        return userDao.updateUserCreditById(id, credit);
    }
}
