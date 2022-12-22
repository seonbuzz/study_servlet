package com.ddonsdevelop.study_servlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


// /session/createServlets?username=yojulab&password=1234
@WebServlet(urlPatterns="/session/getServlets")
public class GetSessionServlets extends HttpServlet {

        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       

        // display
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<div>Create Session Servlets</div>");
        // login 
        HttpSession httpSession = request.getSession();
        String username = (String) httpSession.getAttribute("username");
        String password = (String) httpSession.getAttribute("password");

        printWriter.close();
    }
}
