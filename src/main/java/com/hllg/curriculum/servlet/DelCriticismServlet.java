package com.hllg.curriculum.servlet;

import com.hllg.curriculum.service.CriticismService;
import com.hllg.curriculum.service.impl.CriticismServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/06  Sat  20:38
 */
@WebServlet(value = "/delCriticism")
public class DelCriticismServlet extends HttpServlet {
    private static final long serialVersionUID = -4399393871469790697L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("cid");
        String curriculumId = req.getParameter("curriculumId").trim();
        CriticismService criticismService = new CriticismServiceImpl();
        int delete = criticismService.deleteById(Integer.parseInt(cid));
        if (delete > 0) {
            resp.getWriter().print("<script>alert('删除了');location='/detail?curriculumId=" + curriculumId + "'</script>");
        } else {
            resp.getWriter().print("<script>alert('删除失败了哦');location='/detail?curriculumId=" + curriculumId + "'</script>");
        }

    }
}
