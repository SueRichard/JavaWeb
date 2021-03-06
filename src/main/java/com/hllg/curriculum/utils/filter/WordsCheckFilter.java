package com.hllg.curriculum.utils.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/07  Sun  00:39
 */
public class WordsCheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String criticism = request.getParameter("criticism").trim();
        String[] illegalWords = {"你妈的", "操你妈", "操", "日你", "傻吊"};
        boolean isIllegal = false;
        for (String illegalWord : illegalWords) {
            if (criticism.contains(illegalWord)) {
                response.getWriter().print("<script>alert('你的评论包含不合法字符，请修改。');history.back();</script>");
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
