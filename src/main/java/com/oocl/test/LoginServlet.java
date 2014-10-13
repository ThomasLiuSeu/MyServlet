package com.oocl.test;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: LIUTH2
 * Date: 7/10/14
 * Time: 6:30 PM
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
         String name = request.getParameter("name");
        String password = request.getParameter("password");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
