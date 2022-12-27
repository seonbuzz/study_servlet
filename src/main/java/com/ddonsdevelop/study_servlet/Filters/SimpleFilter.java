package com.ddonsdevelop.study_servlet.Filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;


@WebFilter("/*") // 모든 웹클라이언트에서 오는 것을 필터링 하겠다 !
public class SimpleFilter implements Filter {
    @Override
    public void destroy() {
 
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        System.out.println(request.getRemoteHost());
        System.out.println(request.getRemoteAddr());
        chain.doFilter(request, response);
    }
   
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      
}
}