package com.hllg.curriculum.service.impl;

import com.hllg.curriculum.dao.CriticismDao;
import com.hllg.curriculum.dao.impl.CriticismDaoImpl;
import com.hllg.curriculum.bean.Criticism;
import com.hllg.curriculum.service.CriticismService;

import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/08  Mon  19:29
 */
public class CriticismServiceImpl implements CriticismService {
    private CriticismDao criticismDao = new CriticismDaoImpl();

    @Override
    public List<Criticism> queryByCurriculumId(int id) {
        return criticismDao.queryByCurriculumId(id);
    }

    @Override
    public int deleteById(int id) {
        return criticismDao.deleteById(id);
    }

    @Override
    public int add(Criticism criticism) {
        return criticismDao.add(criticism);
    }
}
