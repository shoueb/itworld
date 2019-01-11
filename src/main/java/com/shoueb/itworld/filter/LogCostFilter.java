package com.shoueb.itworld.filter;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description: 继承Filter的过滤器
 * @Author: admin
 * @Date: 2018/12/24 14:03
 */
public class LogCostFilter implements Filter {
    /**
     * 不需要过滤
     */
    private String[] prefixIignores ;
    /**
     * 不需要过滤的参数
     */
    private String ignoresParam;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ignoresParam = filterConfig.getInitParameter("exclusions");
        if (StringUtils.isNotEmpty(ignoresParam)) {
            prefixIignores = ignoresParam.split(",");
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        if (canIgnore(request)) {
            //不需要直接过
            filterChain.doFilter(request, servletResponse);
            return;
        }
        if(request.getRequestURI().equals("/demo1Servlet")){
            System.out.println("-----------------");
           return;
        }
        //需要过滤
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("url:"+request.getRequestURI()+ "  Execute cost="+(System.currentTimeMillis()-start));
    }

    @Override
    public void destroy() {
        prefixIignores=null;
    }

    /**
     * 验证是否需要过滤
     * @param request http请求
     * @return  true 不需要过滤   false 需要过滤
     */
    private boolean canIgnore(HttpServletRequest request) {
        boolean isExcludedPage = false;
        for (String page : prefixIignores) {
            // 判断是否在过滤url之外
            if (request.getServletPath().indexOf(page)>0) {
                isExcludedPage = true;
                break;
            }
        }
        return isExcludedPage;
    }
}
