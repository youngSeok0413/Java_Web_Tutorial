package com;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("*.html")
public class FilterEx implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Filter init");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head><title>Filter</title></head>");
		out.println("<body>Filter를 지나갔습니다!!</body>");
		out.println("</html>");
		System.out.println("Filter Passed 1");
		
		chain.doFilter(req, res);
		System.out.println("Filter Passed 2");
	}
}
