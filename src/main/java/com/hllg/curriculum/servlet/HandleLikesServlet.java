package com.hllg.curriculum.servlet;

import com.hllg.curriculum.service.CriticismService;
import com.hllg.curriculum.service.impl.CriticismServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/09  Tue  23:02
 */
@WebServlet(urlPatterns = "/updateCriticismLike")
public class HandleLikesServlet extends HttpServlet {
    private static final long serialVersionUID = 6273283243355321246L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int num = Integer.parseInt(req.getParameter("num"));
        CriticismService criticismService = new CriticismServiceImpl();
        int update = criticismService.updateLikesNumberById(id, num);
        PrintWriter writer = resp.getWriter();
        if (update > 0) {
            int likes = criticismService.getLikesNumberById(id);
            writer.print(likes);
        } else {
            writer.print("更新失败");
        }
    }
}
