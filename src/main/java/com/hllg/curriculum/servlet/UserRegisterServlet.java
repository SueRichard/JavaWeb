package com.hllg.curriculum.servlet;

import com.hllg.curriculum.bean.User;
import com.hllg.curriculum.service.UserService;
import com.hllg.curriculum.service.impl.UserServiceImpl;
import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SmartUpload smartUpload = new SmartUpload();
        try {
            //参数：servlet对象，请求，响应，字符串（错误页面地址），是否使用session（false），缓冲区大小（int）字节，缓冲区满了溢出部分是否自动输出到输出流（布尔值）
            PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this, req, resp, null, false, 1024, true);
            //初始化上传文件操作
            smartUpload.initialize(pageContext);
            //设置编码方式
            smartUpload.setCharset("utf-8");
            //上传
            smartUpload.upload();
            //获取文件信息
            File file = smartUpload.getFiles().getFile(0);
            String fileName = file.getFileName();
            String contentType = file.getContentType();
            //指定上传路径，注意空文件夹无法部署到服务器，
            String uploadPath = "/uploadFiles/" + fileName;
            //保存到指定位置，第二个参数为虚拟路径
            file.saveAs(uploadPath, File.SAVEAS_VIRTUAL);
            String username = smartUpload.getRequest().getParameter("username");
            String password = smartUpload.getRequest().getParameter("userpwd1");
            UserService userService = new UserServiceImpl();
            User user = new User();
            user.setName(username);
            user.setPassword(password);
            user.setProfileName(fileName);
            int addUser = userService.addUser(user);
            if (addUser > 0) {
                resp.getWriter().println("<script>alert('注册成功');location='index.jsp'</script>");
            } else {
                resp.getWriter().println("<script>alert('注册失败');location='register.jsp'</script>");
            }
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
    }
}
