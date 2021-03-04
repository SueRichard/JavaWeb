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
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/03  Wed  23:03
 */
@WebServlet(urlPatterns = {"/update"}, initParams = @WebInitParam(name = "code", value = "utf-8"))
public class UpdateCurriculumServlet extends HttpServlet {
    private static final long serialVersionUID = -912234156754644586L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset-utf-8");
        CurriculumDao curriculumDao = new CurriculumDaoImpl();
        String name = new String(req.getParameter("cuName").getBytes("ISO-8859-1"), "UTF-8");
        String price = new String(req.getParameter("cuPrice").getBytes("ISO-8859-1"), "UTF-8");
        String info = new String(req.getParameter("cuInfo").getBytes("ISO-8859-1"), "UTF-8");
        String num = new String(req.getParameter("cuNum").getBytes("ISO-8859-1"), "UTF-8");
        String period = new String(req.getParameter("cuPeriod").getBytes("ISO-8859-1"), "UTF-8");
        String startTime = new String(req.getParameter("cuStartTime").getBytes("ISO-8859-1"), "UTF-8");
        String endTime = new String(req.getParameter("cuEndTime").getBytes("ISO-8859-1"), "UTF-8");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try (PrintWriter writer = resp.getWriter()) {
            Curriculum c = new Curriculum(name, Float.parseFloat(price), info, Integer.parseInt(num), Integer.parseInt(period), format.parse(startTime), format.parse(endTime));
            int id=0;
            int update = curriculumDao.updateById(c, id);
            if (update > 0) {
                writer.print("<script>alert('修改成功');</script>");
                //应该独立一个查询servlet
                resp.sendRedirect("/queryAll");
            } else {
                writer.print("<script>alert('修改失败');</script>");
                resp.sendRedirect("index.jsp");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
