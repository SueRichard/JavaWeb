package com.hllg.curriculum.utils.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/03/06  Sat  13:58
 */
public class DownloadCheckFilter implements Filter {
    private int minDownloadCredit = 0;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        minDownloadCredit = Integer.parseInt(filterConfig.getInitParameter("minDownloadCredit"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        int credit = (int) request.getSession().getAttribute("credit");
        String isRecharge = (String) request.getSession().getAttribute("isRecharge");
        if (credit < minDownloadCredit && (isRecharge == null || "false".equals(isRecharge.trim()))) {
            response.getWriter().print("<script>confirm('你的积分为：" + credit + "，不足100，是否充值？')?location='/recharge.jsp':location='/queryAll'</script>");
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
