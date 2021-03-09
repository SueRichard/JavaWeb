package com.hllg.curriculum.servlet;

import com.hllg.curriculum.service.UserService;
import com.hllg.curriculum.service.impl.UserServiceImpl;

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
 * @time 2021/03/09  Tue  17:01
 */
@WebServlet(urlPatterns = "/checkUsername")
public class CheckUserNameServlet extends HttpServlet {
    private static final long serialVersionUID = 1699701734460453995L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        UserService userService = new UserServiceImpl();
        boolean exist = userService.checkUserExistByUsername(username);
        PrintWriter writer = resp.getWriter();
        if (exist) {
            writer.println("用户名已被使用，不可用。");
        } else {
            writer.print("可用");
        }
    }
}
