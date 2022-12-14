package com.ddonsdevelop.study_servlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.ddonsdevelop.study_servlet.dao.PollWithDB;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/poll/PollServlet")
public class PollDetailServlet extends HttpServlet {
    //특정한 펑션 오버라이딩 재설정 =>doGet
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // input type
String questions_Uid = request.getParameter("QUESTIONS_UID");
//getParameter : 클라이언트(브라우저)에서 들어오는 것들을 잡아낼 때 사용
//getAttribute : 서블릿과 서블릿 사이(또는 서블릿과 jsp 사이)에서 값을 주고받을 때 사용하는 것이 좋음
//구분해서 써야 유지보수해서 쓸 때 좋음.

    //biz with DB and Class
    PollWithDB pollWithDB = new PollWithDB(); //인스턴스화

    HashMap<String, Object> question = null;   //펑션불러오기
    ArrayList<HashMap> answer = null;

   try {
    question = pollWithDB.getQuestion(questions_Uid);  //재선언
    answer = pollWithDB.getAnswer(questions_Uid); //키로 선정을 했기 때문에 파라미터 들어감

    // System.out.println(question.get("QUESTIONS_UID"));
    // System.out.println(question.get("QUESTIONS"));
    // System.out.println(question.get("ORDERS"));

    } catch (SQLException e) {
    

        e.printStackTrace();
    } 

    for(int i=0; i<answer.size(); i++) {
        HashMap<String, Object> result = answer.get(i);
        System.out.println(result.get("ORDERS"));
        System.out.println(result.get("EXAMPLE"));
    }
    //output with html
    request.setAttribute("question", question); 
    // ("객체명",객체);
    request.setAttribute("answer", answer);
    RequestDispatcher requestDispatcher =  request.getRequestDispatcher("/poll/detail.jsp");
    requestDispatcher.forward(request, response);
    }
}
