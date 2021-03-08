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
 * @time 2021/03/03  Wed  23:03
 */
@WebServlet(urlPatterns = {"/update"}, initParams = @WebInitParam(name = "code", value = "utf-8"))
public class UpdateCurriculumServlet extends HttpServlet {
    private static final long serialVersionUID = -912234156754644586L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CurriculumService curriculumService = new CurriculumServiceImpl();
        String id = req.getParameter("cuid");
        String name = req.getParameter("cuName");
        String price = req.getParameter("cuPrice");
        String info = req.getParameter("cuInfo");
        String num = req.getParameter("cuNum");
        String period = req.getParameter("cuPeriod");
        String startTime = req.getParameter("cuStartTime");
        String endTime = req.getParameter("cuEndTime");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try (PrintWriter writer = resp.getWriter()) {
            Curriculum c = new Curriculum(name, Float.parseFloat(price), info, Integer.parseInt(num), Integer.parseInt(period), format.parse(startTime), format.parse(endTime));
            int update = curriculumService.updateById(c, Integer.parseInt(id));
            if (update > 0) {
                writer.print("<script>alert('修改成功');location='/queryAll';</script>");
            } else {
                writer.print("<script>alert('修改失败');</script>");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
