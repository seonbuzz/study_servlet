package com.ddonsdevelop.study_servlet.Filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// @WebFilter("/simple/*")
public class SendRedirectFilter implements Filter {
    @Override
    public void destroy() {
 
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        System.out.println(request.getRemoteHost());
        System.out.println(request.getRemoteAddr());
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String uri = httpServletRequest.getRequestURI();

        if(uri.endsWith("Servlet")){
            httpServletResponse.sendRedirect("/index.html"); //sendRedirect : 웹서버에게 이 경로를 찍어서 보내는 것
        }else {
            chain.doFilter(request, response); // =dispatcher
        }
    }
   
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      
}
}