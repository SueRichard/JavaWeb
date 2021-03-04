package com.hllg.userLogin.servlet;

import com.hllg.userLogin.dao.CurriculumDao;
import com.hllg.userLogin.dao.impl.CurriculumDaoImpl;
import com.hllg.userLogin.model.Curriculum;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/04  Thu  11:22
 */
@WebServlet(urlPatterns = {"/queryAll"},initParams = @WebInitParam(name = "code",value = "utf-8"))
public class QueryCurriculumServlet extends HttpServlet {
    private static final long serialVersionUID = 4573757948929953797L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CurriculumDao curriculumDao = new CurriculumDaoImpl();
        List<Curriculum> curricula = curriculumDao.findAll();
            HttpSession session = req.getSession();
            session.setAttribute("curricula",curricula);
            resp.sendRedirect("curriculum.jsp");
    }
}
