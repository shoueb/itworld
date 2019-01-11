package com.shoueb.itworld.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: servlet例子
 * @Author: admin
 * @Date: 2018/12/24 13:49
 */
@WebServlet(name = "demoServlet", urlPatterns = "/demoServlet")
public class DemoServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.getWriter().append("servlet demo");
    }

}
