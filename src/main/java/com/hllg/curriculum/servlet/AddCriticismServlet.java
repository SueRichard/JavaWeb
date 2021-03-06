package com.hllg.curriculum.servlet;

import com.hllg.curriculum.dao.CriticismDao;
import com.hllg.curriculum.dao.impl.CriticismDaoImpl;
import com.hllg.curriculum.model.Criticism;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/06  Sat  20:51
 */
@WebServlet(value = "/addCriticism")
public class AddCriticismServlet extends HttpServlet {
    private static final long serialVersionUID = 1283580544117732149L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String criticism = req.getParameter("criticism").trim();
        int curriculumId = Integer.parseInt(req.getParameter("curriculumId"));
        int id = (int) req.getSession().getAttribute("id");
        Criticism c = new Criticism(id, curriculumId, criticism, new Date());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(new Date()));
        CriticismDao criticismDao = new CriticismDaoImpl();
        int add = criticismDao.add(c);
        if (add > 0) {
            resp.getWriter().print("<script>alert('添加成功');location='/detail?curriculumId=" + curriculumId + "'</script>");
        } else {
            resp.getWriter().print("<script>alert('添加失败');location='/detail?curriculumId" + curriculumId + "'</script>");
        }
    }
}
