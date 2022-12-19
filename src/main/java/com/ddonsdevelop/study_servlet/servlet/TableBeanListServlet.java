package com.ddonsdevelop.study_servlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.ddonsdevelop.study_servlet.DatasInfor;
import com.ddonsdevelop.study_servlet.beans.MemberBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/tableBeanListServlet")
public class TableBeanListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
        DatasInfor datasInfor = new DatasInfor();
        // MemberBean memberBean = datasInfor.getDataWithMemberBean();
        HashMap<String, Object> bundleData = datasInfor.getBundlesData();
        

        
        //display areas
        PrintWriter printWriter = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        
        // HashMap<String, String> searchForm = datasInfor.getSearchFormData();
        printWriter.println ("<html lang='en'>");
        printWriter.println ("<head>");
        printWriter.println ("<meta charset='UTF-8'>");
        
        printWriter.println (" <link rel='stylesheet' href='./css/common.css' />");
        printWriter.println ("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65' crossorigin='anonymous'/>");
        
        
        
        printWriter.println ("<title>Table Bean List Servlet</title>");
        printWriter.println ("</head>");
        printWriter.println ("<body>");
        printWriter.println (" <div class='container'>");
        printWriter.println ("  <div class='fs-3'>Table with Bean</div>");
      
        MemberBean memberBean2 = (MemberBean) bundleData.get("dataWithMemberBean");
        printWriter.println(memberBean2.getFirstName() + " " + memberBean2.getSecondName()
        + " " + memberBean2.getHandleName());
        // printWriter.println("<div class='fs-4'>"+memberBean.getFirstName() + " " + memberBean.getSecondName()
        // + " " + memberBean.getHandleName()+"</div>");

        printWriter.println ("  <table class='table'>");
        printWriter.println ("<thead>");
        printWriter.println ("  <tr>");
        printWriter.println ("   <th scope=>#</th>");
        // printWriter.println ("   <th scope=>First</th>");
        // printWriter.println ("   <th scope=>Last</th>");
        printWriter.println ("    <th scope=>Handle</th>");
        printWriter.println ("   </tr>");
        printWriter.println (" </thead>");
        printWriter.println ("  <tbody>");

        ArrayList<MemberBean> dataListWithMemberBean = (ArrayList<MemberBean>) bundleData.get("dataWithMemberBean");
        for(int i=0; i<dataListWithMemberBean.size(); i++){

            MemberBean memberBean=  dataListWithMemberBean.get(i);

            printWriter.println ("   <tr>");
            printWriter.println ("   <th scope=>"+(i+1)+"</th>");
            String handle = memberBean.getHandleName();
            printWriter.println ("   <td>"+memberBean.getFirstName()+"</td>");
            printWriter.println ("   <td>"+memberBean.getSecondName()+"</td>");
            printWriter.println ("   <td>"+handle+"</td>");
            printWriter.println (" </tr>");
        }
        printWriter.println ("  </tbody>");
        printWriter.println ("  </table>");
        printWriter.println (" </div>");
        printWriter.println ("<script");
        printWriter.println (" src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'");
        printWriter.println ("integrity='sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4'");
        printWriter.println ("crossorigin='anonymous'");
        printWriter.println (" ></script>");
        printWriter.println (" </body>");
        printWriter.println (" </html>");
        printWriter.close();
    }
    
}
