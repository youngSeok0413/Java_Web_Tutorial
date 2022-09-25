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

@WebServlet("/postsend")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException {
		System.out.println("doPost 메서드 호출");
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		PrintWriter writer = resp.getWriter();
		
		String user = req.getParameter("user");
		String pwd = req.getParameter("pwd");
		
		writer.println("<html>");
		writer.println("<head><title>Login Result</title></head>");
		writer.println("<body>유저 이름은 " + user + "이고 "+"패스워드는 "+pwd+"이다.</body>");
		writer.println("</html>");
	}
}
