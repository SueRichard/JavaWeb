package com.hllg.curriculum.utils;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/05  Fri  12:02
 */
public class InitFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //处理所有servlet乱码
        request.setCharacterEncoding("UTF-8");
        String user = (String) request.getSession().getAttribute("user");
        String uri = request.getRequestURI();
        //设置资源放行，指定资源可以在未登录的情况下访问，或者有session的情况下
        if (uri.endsWith("/index.jsp") || uri.endsWith("/") || user != null) {
            //进入下一个Filter或者servlet
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect("/index.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
