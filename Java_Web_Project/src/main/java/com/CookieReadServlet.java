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

@WebServlet("/readcookie")
public class CookieReadServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("");
		PrintWriter out = resp.getWriter();
		Cookie[] cookies = req.getCookies();
		
		out.println("<html>");
		out.println("<head><title>Reading Cookie</title></head>");
		out.println("<body>");
		if(cookies!=null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("food")) {
					out.println("cookie::" + cookie.getValue());
				}
			}
		}
		
		out.println("</body></html>");
		//System.out.println("Read a cookie");
	}
}
