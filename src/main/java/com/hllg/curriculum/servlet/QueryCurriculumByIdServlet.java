package com.hllg.curriculum.servlet;

import com.hllg.curriculum.model.Curriculum;
import com.hllg.curriculum.service.CurriculumService;
import com.hllg.curriculum.service.impl.CurriculumServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/04  Thu  13:58
 */

@WebServlet(urlPatterns = {"/queryById"}, initParams = @WebInitParam(name = "code", value = "utf-8"))
public class QueryCurriculumByIdServlet extends HttpServlet {
    private static final long serialVersionUID = -8804344651488052407L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * @Description 暂未使用
         * @param req
         * @param resp
         * @return void
         * @Author HLLG
         * @Date 04/03/2021 20:29
         **/
        CurriculumService curriculumService = new CurriculumServiceImpl();
        String id = req.getParameter("id");
        Curriculum curriculum = curriculumService.queryById(Integer.parseInt(id));
        HttpSession session = req.getSession();
        session.setAttribute("singleCourse", curriculum);
    }
}
