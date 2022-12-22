package com.ddonsdevelop.study_servlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dispatcherServlet")
public class DispatcherServlet extends HttpServlet  {

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

            // request.getParameter("LEGACY_DO_HEAD")
            //request => request의 값을 받을 때
            //response =>브라우저의 값을 그대로 던져줄때/ 밖으로 내보낼때

            String hiddenParam = request.getParameter("hiddenParam");

            //dispatcherServlet?hiddenParam=searchFormServlet
            if("searchFormServlet".equals(hiddenParam)) {
              //dispatcherServlet?hiddenParam=searchFormServlet
                response.sendRedirect("/searchFormServlet");
            }else if ("createCookieServlets".equals(hiddenParam)){
              request.setAttribute("firstName","ddon");
              RequestDispatcher requestDispatcher =  request.getRequestDispatcher("/cookies/createServlets");
              requestDispatcher.forward(request, response);
            } else {
              //normal display         
              String message = "HelloWorldServlet with Message!";
              PrintWriter printWriter = response.getWriter();             
            
              printWriter.println ("<html lang='en'>");
              printWriter.println("<head>");
              
              printWriter.println("<title>"+message+"</title>");
              printWriter.println("</head>");
              printWriter.println("<body>");                      
              
              printWriter.println(" <button>recall helloWorldServlet</button>");
              printWriter.println(" </form>");
                           
              printWriter.println("</body>"); 
              printWriter.println("</html>");
              
            printWriter.close();
            }
        }

    
}
