<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.HashMap, java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <title>Document</title>
  </head>
  <body>
  <% 
  HashMap<String, Object> question = (HashMap<String, Object>)request.getAttribute("question"); 
  ArrayList<HashMap> answer = (ArrayList<HashMap>) request.getAttribute("answer");
  %>
  <%-- getAttribute : type이 Object이기 때문에 반드시 형변환 해줘야함.  --%>

    <%-- <div>
      <a href="/poll/PollServlet?QUESTIONS_UID=Q1">Q1</a> /
      <a href="/poll/PollServlet?QUESTIONS_UID=Q2">Q2</a> /
      <a href="/poll/PollServlet?QUESTIONS_UID=Q3">Q3</a> /
      <a href="/poll/PollServlet?QUESTIONS_UID=Q4">Q4</a> /
      <a href="/poll/PollServlet?QUESTIONS_UID=Q5">Q5</a> 
    </div> --%>
    <div class="container m-auto">

    <% for(int i=1; i<6; i++){ %>
     <a href="/poll/PollServlet?QUESTIONS_UID=Q<%= i%>">Q<%= i%></a><%=" "%>
     <%-- QUESTIONS_UID=Q__ --%>

   <% } %>
   <div>
    <%= question.get("ORDERS") %>. <%= question.get("QUESTIONS") %>
    </div>

    <% for(int i=0; i<answer.size(); i++){ %>
      <div> <%= (i+1) %>. <%= answer.get(i)  %> </div>

    <% } %>

    </div>
       <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
