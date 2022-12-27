
  <%@ page import="java.util.HashMap, java.util.ArrayList" %>
  <% 
  HashMap<String, String> searchForm01 = (HashMap<String, String>)request.getAttribute("searchForm");
  %>
<%= searchForm01.get("search_key") %>
 <%! String url = "location.href= 'tableListServlet' "; %>
 <button class="btn btn-primary" onclick="<%= url %>">Next</button>

      <nav class="navbar navbar-expand bg-light">
        <div class="navbar-nav">
          <a href="" class="nav-link">Home</a>
          <a href="" class="nav-link">Feature</a>
          <a href="" class="nav-link">Pricing</a>
        </div>
      </nav>
   <hr>
    
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
