package com.hllg.curriculum.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/12  Fri  10:00
 */
@WebServlet(urlPatterns = "/profileDownload")
public class ProFileDownloadServlet extends HttpServlet {
    private static final long serialVersionUID = -7392802708088281811L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("filename");
        String path = "/uploadFiles/" + filename;
        //设置响应头信息和响应类型
        resp.setContentType("application/octet-stream");
        //添加头信息，指定编码格式，防止中文乱码
        resp.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
        //跳转页面
        req.getRequestDispatcher(path).forward(req, resp);
        //清空缓存区
        resp.flushBuffer();
    }
}
