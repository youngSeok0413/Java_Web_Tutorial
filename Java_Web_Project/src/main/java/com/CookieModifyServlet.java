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

@WebServlet("/modifyCookie")
public class CookieModifyServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html><head>Cookie Modify</head>");
		out.println("<body>");
		Cookie[] cookies = req.getCookies();
		if(cookies!=null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("food")) {
					Cookie modifiedCookie = new Cookie("food", "pizza");
					resp.addCookie(modifiedCookie);
				}
			}
		}
		
		out.println("<a href='/Java_Web_Project/readcookie'>read cookie</a>");
		out.println("</body></html>");
	}
}
