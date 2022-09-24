package com;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
		name="init", urlPatterns={"/init", "/init1"},
		initParams = {@WebInitParam(name = "sitename", value = "jpub")}
		)
public class Init extends HttpServlet{
	private String webname;
	
	@Override
	public void init(ServletConfig servletconfig) throws ServletException{
		System.out.println("I init the Init Servelt!!");
		this.webname = servletconfig.getInitParameter("sitename");
		System.out.println(webname);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.getWriter().println("Hello Servlet");
		System.out.println("Get");
	}
}
