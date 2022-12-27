package com.ddonsdevelop.study_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/helloWorldServlet")
public class HelloWorldServlet extends HttpServlet  {

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

            // request.getParameter("LEGACY_DO_HEAD")
            //request => request의 값을 받을 때
            //resoponse =>브라우저의 값을 그대로 던져줄때/ 밖으로 내보낼때
            String firstName = request.getParameter("firstName");
            String secondName = request.getParameter("secondName");
            String hiddenParam = request.getParameter("hiddenParam");
            String message = "HelloWorldServlet with Message!";
            PrintWriter printWriter = response.getWriter();


            printWriter.println ("<html lang='en'>");
            printWriter.println("<head>");
    
            printWriter.println("<title>"+message+"</title>");
            printWriter.println("</head>");
            printWriter.println("<body>");
            printWriter.println("<div> firstName :"+firstName+"</div>");
            printWriter.println("<div> secondName :"+secondName+"</div>");
   
            printWriter.println("<form action='/helloWorldServlet?firstName=Seonah&secondName=Yun' method='get' >");
          printWriter.println("<input type='text' name='firstName' id='' value='"+firstName+"' />");
          printWriter.println("<input type='text' name='secondName' id='' value='"+secondName+"' />");
          printWriter.println(" <button>recall helloWorldServlet</button>");
          printWriter.println(" </form>");
            printWriter.println("</body>"); 
            printWriter.println("</html>");
          
            printWriter.close();
        }

    
}
