package com.hllg.curriculum.servlet;

import com.hllg.curriculum.dao.CurriculumDao;
import com.hllg.curriculum.dao.impl.CurriculumDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/03  Wed  23:02
 */
@WebServlet(urlPatterns = {"/delete"},initParams = @WebInitParam(name = "code",value = "utf-8"))
public class DeleteCurriculumServlet extends HttpServlet {
    private static final long serialVersionUID = 2058007156373642719L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset-utf-8");
        CurriculumDao curriculumDao = new CurriculumDaoImpl();
        String id = new String(req.getParameter("id").getBytes("ISO-8859-1"), "UTF-8");
        try (PrintWriter writer = resp.getWriter()) {
            int delete = curriculumDao.delete(Integer.parseInt(id));
            if (delete > 0) {
                writer.print("<script>alert('删除成功');</script>");
                //应该独立一个查询servlet
                resp.sendRedirect("/queryAll");
            } else {
                writer.print("<script>alert('删除失败');</script>");
                resp.sendRedirect("index.jsp");
            }
        }
    }
}
