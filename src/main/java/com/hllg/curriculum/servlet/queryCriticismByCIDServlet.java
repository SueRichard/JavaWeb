package com.hllg.curriculum.servlet;

import com.hllg.curriculum.model.Criticism;
import com.hllg.curriculum.model.Curriculum;
import com.hllg.curriculum.service.CriticismService;
import com.hllg.curriculum.service.CurriculumService;
import com.hllg.curriculum.service.impl.CriticismServiceImpl;
import com.hllg.curriculum.service.impl.CurriculumServiceImpl;

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
        CriticismService criticismService = new CriticismServiceImpl();
        CurriculumService curriculumService = new CurriculumServiceImpl();
        Curriculum curriculum = curriculumService.queryById(curriculumId);
        List<Criticism> criticisms = criticismService.queryByCurriculumId(curriculumId);
        req.getSession().setAttribute("course", curriculum);
        req.getSession().setAttribute("criticisms", criticisms);
        resp.sendRedirect("detail.jsp");
    }
}
