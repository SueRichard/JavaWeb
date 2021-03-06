package com.hllg.curriculum.dao;

import com.hllg.curriculum.bean.Criticism;

import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/06  Sat  18:01
 */
public interface CriticismDao {
    List<Criticism> queryByCurriculumId(int id);

    int deleteById(int id);

    int add(Criticism criticism);

    int updateLikesNumberById(int id, int number);

    int getLikesNumberById(int id);
}
