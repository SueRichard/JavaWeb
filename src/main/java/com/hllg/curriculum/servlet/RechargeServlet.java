package com.hllg.curriculum.servlet;

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
 * @time 2021/03/08  Mon  14:35
 */
@WebServlet(value = "/recharge")
public class RechargeServlet extends HttpServlet {
    private static final long serialVersionUID = 8796357145348843676L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int credit = Integer.parseInt(req.getParameter("amount")) * 10;
        int id = (int) req.getSession().getAttribute("id");
        UserService userService = new UserServiceImpl();
        int result = userService.updateUserCreditById(id, credit);
        if (result > 0) {
            req.getSession().setAttribute("isRecharge", "true");
            resp.getWriter().print("<script>alert('恭喜您，充值成功！');location='/download';</script>");
        } else {
            req.getSession().setAttribute("isRecharge", "false");
            resp.getWriter().print("<script>alert('出错喽，充值失败，请重试！');location='/queryAll';</script>");
        }
    }
}
