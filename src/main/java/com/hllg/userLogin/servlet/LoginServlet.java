package com.hllg.userLogin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/02  Tue  19:56
 */
@WebServlet(urlPatterns = {"/login"},loadOnStartup = 1,initParams = {
        @WebInitParam(name = "code",value = "utf-8")
})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
