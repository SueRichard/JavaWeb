package com.hllg.curriculum.service;

import com.hllg.curriculum.bean.Curriculum;

import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/08  Mon  19:26
 */
public interface CurriculumService {
    List<Curriculum> findAll();

    int add(Curriculum c);

    int delete(int id);

    int updateById(Curriculum c, int id);

    Curriculum queryById(int id);
}
