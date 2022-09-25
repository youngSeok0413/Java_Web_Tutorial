package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.WriteAbortedException;
import java.io.Writer;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/helloget")
public class HelloServlet1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException {
		System.out.println("doGet 메서드 호출");
		
		//Encoding Type
		resp.setCharacterEncoding("utf-8");
		//Content Type 
		resp.setContentType("text/html");
		
		PrintWriter writer = resp.getWriter();
				
		writer.println("<html>");
		writer.println("<head><title>jpub java servlet webservice</title></head>");
		writer.println("<body>get 요청입니다.</body>");
		writer.println("</html>");
	}
}
