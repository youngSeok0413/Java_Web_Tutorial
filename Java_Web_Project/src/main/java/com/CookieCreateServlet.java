package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.WriteAbortedException;
import java.io.Writer;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/newCookie")
public class CookieCreateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>Making Cookie</title></head>");
		out.println("<body>쿠키 만들기 요청입니다.<br>");
		
		Cookie cookie = new Cookie("food","chicken");
		cookie.setMaxAge(3600);
		resp.addCookie(cookie);
		
		out.println("<a href='/readcookie'>read cookie</a>");
		out.println("</body></html>");
		
	}
}
