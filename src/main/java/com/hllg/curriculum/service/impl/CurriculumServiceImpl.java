package com.hllg.curriculum.service.impl;

import com.hllg.curriculum.dao.CurriculumDao;
import com.hllg.curriculum.dao.impl.CurriculumDaoImpl;
import com.hllg.curriculum.model.Curriculum;
import com.hllg.curriculum.service.CurriculumService;

import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/08  Mon  19:27
 */
public class CurriculumServiceImpl implements CurriculumService {
    private CurriculumDao curriculumDao = new CurriculumDaoImpl();

    @Override
    public List<Curriculum> findAll() {
        return curriculumDao.findAll();
    }

    @Override
    public int add(Curriculum c) {
        return curriculumDao.add(c);
    }

    @Override
    public int delete(int id) {
        return curriculumDao.delete(id);
    }

    @Override
    public int updateById(Curriculum c, int id) {
        return curriculumDao.updateById(c, id);
    }

    @Override
    public Curriculum queryById(int id) {
        return curriculumDao.queryById(id);
    }
}
