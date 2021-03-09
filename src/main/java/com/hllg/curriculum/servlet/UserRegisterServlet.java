package com.hllg.curriculum.servlet;

import com.hllg.curriculum.bean.User;
import com.hllg.curriculum.service.UserService;
import com.hllg.curriculum.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/09  Tue  16:07
 */
@WebServlet(urlPatterns = "/register")
public class UserRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = -6555577939985640277L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("userpwd1");
        UserService userService = new UserServiceImpl();
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        int addUser = userService.addUser(user);
        if (addUser > 0) {
            resp.getWriter().println("<script>alert('注册成功');location='index.jsp'</script>");
        } else {
            resp.getWriter().println("<script>alert('注册失败');location='register.jsp'</script>");
        }
    }
}
