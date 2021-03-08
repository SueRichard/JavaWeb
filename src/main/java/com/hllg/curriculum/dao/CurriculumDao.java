package com.hllg.curriculum.dao;

import com.hllg.curriculum.bean.Curriculum;

import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/03  Wed  20:34
 */
public interface CurriculumDao {
    List<Curriculum> findAll();

    int add(Curriculum c);

    int delete(int id);

    int updateById(Curriculum c, int id);

    Curriculum queryById(int id);
}
