package com.hllg.curriculum.utils.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/05  Fri  12:02
 */
public class InitFilter implements Filter {
    private String encoding = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(System.getProperty("file.encoding"));
        System.out.println("init过滤器初始化");
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("init过滤器开始工作");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //处理所有servlet乱码
        if (encoding != null) {
            request.setCharacterEncoding(encoding);
            response.setContentType("text/html;charset=" + encoding);
        }
        String user = (String) request.getSession().getAttribute("user");
        String uri = request.getRequestURI();
        System.out.println(uri);
        //设置资源放行，指定资源可以在未登录的情况下访问，或者有session的情况下
        if (uri.endsWith("/index.jsp") || uri.endsWith("/login") || uri.endsWith("/") || uri.contains("/js/") || uri.contains("/css/") || uri.contains("/img/") || uri.contains("/favicon") || user != null) {
            //进入下一个Filter或者servlet
            System.out.println("通过pass");
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            System.out.println("被拦截failed");
            response.sendRedirect("/index.jsp");
        }
    }

    @Override
    public void destroy() {
        System.out.println("init过滤器销毁");
        encoding = null;
    }
}
