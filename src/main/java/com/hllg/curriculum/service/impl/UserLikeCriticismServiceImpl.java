package com.hllg.curriculum.service.impl;

import com.hllg.curriculum.bean.UserLikeCriticism;
import com.hllg.curriculum.dao.UserLikeCriticismDao;
import com.hllg.curriculum.dao.impl.UserLikeCriticismDaoImpl;
import com.hllg.curriculum.service.UserLikeCriticismService;

import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/09  Tue  20:56
 */
public class UserLikeCriticismServiceImpl implements UserLikeCriticismService {
    private UserLikeCriticismDao userLikeCriticismDao = new UserLikeCriticismDaoImpl();

    @Override
    public List<UserLikeCriticism> findAllLikes() {
        return userLikeCriticismDao.findAllLikes();
    }

    @Override
    public List<UserLikeCriticism> findAllLikesByCriticismId(int cid) {
        return userLikeCriticismDao.findAllLikesByCriticismId(cid);
    }

    @Override
    public int addLike(int uid, int cid) {
        return userLikeCriticismDao.addLike(uid, cid);
    }

    @Override
    public int deleteLike(int id) {
        return userLikeCriticismDao.deleteLike(id);
    }
}
