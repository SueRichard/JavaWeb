package com.hllg.curriculum.servlet;

import com.hllg.curriculum.bean.Curriculum;
import com.hllg.curriculum.service.CurriculumService;
import com.hllg.curriculum.service.impl.CurriculumServiceImpl;

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
 * @time 2021/03/03  Wed  23:04
 */
@WebServlet(urlPatterns = {"/addCurriculum"}, initParams = @WebInitParam(name = "code", value = "utf-8"))
public class AddCurriculumServlet extends HttpServlet {
    private static final long serialVersionUID = -167192301856130926L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CurriculumService curriculumService = new CurriculumServiceImpl();
        String name = req.getParameter("cname");
        String price = req.getParameter("cprice");
        String info = req.getParameter("cinfo");
        String num = req.getParameter("cnum");
        String period = req.getParameter("cperiod");
        String startTime = req.getParameter("cstartTime");
        String endTime = req.getParameter("cendTime");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try (PrintWriter writer = resp.getWriter()) {
            Curriculum c = new Curriculum(name, Float.parseFloat(price), info, Integer.parseInt(num), Integer.parseInt(period), format.parse(startTime), format.parse(endTime));
            int add = curriculumService.add(c);
            if (add > 0) {
                writer.print("<script>alert('添加成功');location='/queryAll'</script>");
            } else {
                writer.print("<script>alert('添加失败');</script>");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
