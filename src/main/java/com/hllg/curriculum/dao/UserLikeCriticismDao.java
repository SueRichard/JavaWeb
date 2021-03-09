package com.hllg.curriculum.dao;

import com.hllg.curriculum.bean.UserLikeCriticism;

import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/09  Tue  20:23
 */
public interface UserLikeCriticismDao {
    List<UserLikeCriticism> findAllLikes();

    /**
     * 根据评论获取喜欢
     *
     * @param cid 评论id
     * @return list
     * @Author HLLG
     * @Date 09/03/2021 21:16
     **/
    List<UserLikeCriticism> findAllLikesByCriticismId(int cid);

    /**
     * 增加喜欢的评论
     *
     * @param uid 用户id
     * @param cid 评论id
     * @return int
     * @Author HLLG
     * @Date 09/03/2021 20:42
     **/
    int addLike(int uid, int cid);

    /**
     * 移除喜欢某一个评论
     *
     * @param id like表id
     * @return int
     * @Author HLLG
     * @Date 09/03/2021 20:41
     **/
    int deleteLike(int id);
}
