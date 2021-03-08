package com.hllg.curriculum.service;

import com.hllg.curriculum.model.Criticism;

import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/08  Mon  19:28
 */
public interface CriticismService {
    List<Criticism> queryByCurriculumId(int id);

    int deleteById(int id);

    int add(Criticism criticism);
}
