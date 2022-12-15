package com.ddonsdevelop.study_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/formSelectServlet")
public class FormSelectServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

        PrintWriter printWriter = response.getWriter();
        
        String title = "FormSelect";
        printWriter.println ("<html lang='en'>");
        printWriter.println ("<head>");
    
        printWriter.println ("<link rel='stylesheet' href='./css/common.css' />");

    printWriter.println ("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65' crossorigin='anonymous'/>");
    printWriter.println ("<title>"+title+"</title>");
    printWriter.println ("</head>");
    printWriter.println ("<body>");
    printWriter.println ("<div class='fs-3'>form select</div>");
    printWriter.println ("<div>");
    printWriter.println ("<label for=' class='form-label'>Select</label>");
    printWriter.println ("<select class='form-select' aria-label='>");
    printWriter.println ("<option selected>Open this select menu</option>");
    printWriter.println ("<option value='1'>One</option>");
    printWriter.println ("<option value='2'>Two</option>");
    printWriter.println (" <option value='3'>Three</option>");
    printWriter.println ("</select>");
    printWriter.println (" </div>");
    printWriter.println ("<div>");
    printWriter.println (" <label for=' class='form-label'>Select multipole</label>");
    printWriter.println ("<select class='form-select' aria-label=' multiple>");
    printWriter.println (" <option value='1'>One</option>");
    printWriter.println ("<option value='2'>Two</option>");
    printWriter.println ("<option value='3'>Three</option>");
    printWriter.println (" <option value='4'>Four</option>");
    printWriter.println (" <option value='5'>Five</option>");
    printWriter.println ("</select>");
    printWriter.println ("</div>");
    printWriter.println ("<script");
        printWriter.println ("src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'");
        printWriter.println ("integrity='sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4'");
        printWriter.println ("crossorigin='anonymous'");
        printWriter.println (" ></script>");
    printWriter.println ("</html>");

    printWriter.close();
        
    }
}
