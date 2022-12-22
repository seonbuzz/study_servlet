package com.ddonsdevelop.study_servlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dispatcherJSPServlet")
public class DispatcherJSPServlet extends HttpServlet  {

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

            // request.getParameter("LEGACY_DO_HEAD")
            //request => request의 값을 받을 때
            //response =>브라우저의 값을 그대로 던져줄때/ 밖으로 내보낼때

            String hiddenParam = request.getParameter("hiddenParam");

       
        //       response.sendRedirect("/search_form.jsp");

                request.setAttribute("firstName", "ddons");
              RequestDispatcher requestDispatcher =  request.getRequestDispatcher("/search_form.jsp");
              requestDispatcher.forward(request, response);
          
            
        }

    
}
