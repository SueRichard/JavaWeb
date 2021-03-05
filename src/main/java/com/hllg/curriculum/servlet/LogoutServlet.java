package com.hllg.curriculum.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/05  Fri  11:52
 */
@WebServlet(value = "/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = -7792628054169112106L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //只移除单个会话属性
//        req.getSession().removeAttribute("user");
//        移除所有session属性
        req.getSession().invalidate();
        resp.sendRedirect("index.jsp");
    }
}
