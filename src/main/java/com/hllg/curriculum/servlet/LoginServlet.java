package com.hllg.curriculum.servlet;

import com.hllg.curriculum.dao.UserDao;
import com.hllg.curriculum.dao.impl.UserDaoImpl;
import com.hllg.curriculum.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/02  Tue  19:56
 */
@WebServlet(urlPatterns = {"/login"}, loadOnStartup = 1, initParams = {
        @WebInitParam(name = "code", value = "utf-8")
})
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = -5667864431189502744L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("userpwd");
        UserDao userDao = new UserDaoImpl();
        User user = userDao.userLoginCheck(username, password);
        if (user.getName() != null) {
            String message = "登录成功！<br/>尊敬的<b>" + user.getName() + "</b>，你好！";
            HttpSession session = req.getSession();
            session.setAttribute("id", user.getId());
            session.setAttribute("user", user.getName());
            session.setAttribute("msg", message);
            Cookie cookie = new Cookie("username",username);
            resp.addCookie(cookie);
            resp.sendRedirect("/queryAll");
        } else {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.print("<script>alert('登录失败，请重试！');location.href='/index.jsp';</script>");
            writer.close();
        }
    }
}
