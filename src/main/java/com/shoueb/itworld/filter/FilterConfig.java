package com.shoueb.itworld.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 过滤器
 * @Author: admin
 * @Date: 2018/12/24 14:06
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new LogCostFilter());
        registration.addUrlPatterns("/*");
        registration.setName("LogCostFilter");
        registration.addInitParameter("targetFilterLifecycle","true");
        registration.addInitParameter("exclusions", ".js,.gif,.jpg,.png,.css,.ico,/reg");
        registration.setOrder(1);
        return registration;
    }

}