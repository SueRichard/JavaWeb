package com.hllg.curriculum.servlet;

import com.hllg.curriculum.dao.UserDao;
import com.hllg.curriculum.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/06  Sat  23:25
 */
@WebServlet(value = "/download")
public class DownloadServlet extends HttpServlet {
    private static final long serialVersionUID = 691485700198547257L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseId = req.getParameter("courseId");
        int id = (int) req.getSession().getAttribute("id");
        UserDao userDao = new UserDaoImpl();
        int updateUserCredit = userDao.updateUserCreditById(id, -100);
        if (updateUserCredit > 0) {
            resp.sendRedirect("/download.jsp");
        } else {
            resp.getWriter().println("<script>confirm('下载失败，积分不足，是否充值？')?location='/recharge.jsp':location='/detail?curriculumId=" + courseId + "'</script>");
        }
    }
}
