package com.ddonsdevelop.study_servlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// /session/createJSPServlets?username=ddon&password=1234
@WebServlet(urlPatterns="/session/createJSPServlets")
public class CreateSessionJSPServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // display
     
        // login 
        HttpSession httpSession = null;
        HttpSession httpSession_false = null;

        //WHEN EXIST JSESSIONID
        // httpSession_false = request.getSession(false); //존재하면 인스턴스화
        // httpSession = request.getSession(); //무조건 인스턴스화


        //WHEN NOT EXIST JSESSIONID
        // httpSession_false = request.getSession(false); //Null
        // httpSession = request.getSession(); //Instance of Session 무조건

        String path = null;
        if("ddon".equals(username) && "1234".equals(password)){
            //login

            httpSession = request.getSession(false); //false :  ID를 create or not하는 차이??
            if(httpSession == null){
                httpSession = request.getSession(); //false :  ID를 create or not하는 차이??
                httpSession.setAttribute("username", username);
                httpSession.setAttribute("password", password);
            }
            
            System.out.println(httpSession.getAttribute("username"));
            System.out.println(httpSession.getId());
            path = "/session/checkLogin.jsp";
        } else {
            // logout
            httpSession = request.getSession(false);
            if (httpSession!=null){
                
                httpSession.invalidate();
            }
            
            System.out.println(httpSession.getAttribute("username"));
            System.out.println(httpSession.getId());
            //null인지 아닌지 체크
            
            path = "/session/checkLogout.jsp";
        }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
            //이건 여러번 사용하면 좋지 않음. 그래서 경로를 미리 선언하고 변수만 넣는 것
            //밖으로 빼서 한번에!
            requestDispatcher.forward(request, response);
       
    }
}
