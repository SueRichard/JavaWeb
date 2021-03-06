package com.hllg.curriculum.servlet;

import com.hllg.curriculum.dao.CriticismDao;
import com.hllg.curriculum.dao.CurriculumDao;
import com.hllg.curriculum.dao.impl.CriticismDaoImpl;
import com.hllg.curriculum.dao.impl.CurriculumDaoImpl;
import com.hllg.curriculum.model.Criticism;
import com.hllg.curriculum.model.Curriculum;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/06  Sat  18:14
 */
@WebServlet(value = "/detail")
public class queryCriticismByCIDServlet extends HttpServlet {
    private static final long serialVersionUID = -1486946449635287425L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int curriculumId = Integer.parseInt(req.getParameter("curriculumId"));
        CriticismDao criticismDao = new CriticismDaoImpl();
        CurriculumDao curriculumDao = new CurriculumDaoImpl();
        Curriculum curriculum = curriculumDao.queryById(curriculumId);
        List<Criticism> criticisms = criticismDao.queryByCurriculumId(curriculumId);
        req.getSession().setAttribute("course", curriculum);
        req.getSession().setAttribute("criticisms", criticisms);
        resp.sendRedirect("detail.jsp");
    }
}
