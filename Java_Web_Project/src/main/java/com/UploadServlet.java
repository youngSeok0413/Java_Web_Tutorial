package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.WriteAbortedException;
import java.io.Writer;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig(
	fileSizeThreshold = 1024*1024*2,
	maxFileSize = 1024 * 1024 * 10,
	maxRequestSize = 1024*1024*50,
	location = "D:/Work/Java_Web_Tutorial/upload"
)
public class UploadServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		final String path = req.getParameter("destination");
		final Part filePart = req.getPart("file");
		
		final String fileName = getFileName(filePart);
		final PrintWriter writer = resp.getWriter();
		
		try(OutputStream out = new FileOutputStream(new File(path + File.separator + fileName)); 
				InputStream filecontent = filePart.getInputStream()) {
			
			int read = 0;
			final byte[] bytes = new byte[1024];
			
			while((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			
			writer.print("new File: " + fileName + path + "에 생성되었습니다.");
			
		} catch (FileNotFoundException fne) {
			System.out.println(fne.getMessage());
		}
		
		
	}
	
	private String getFileName(final Part part) {
		final String partHeader = part.getHeader("content-disposition");
		System.out.println("Part Header = {0}" + partHeader);
		for(String content : part.getHeader("content-disposition").split(";")) {
			if(content.trim().startsWith("filename")) {
				return content.substring(
					content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
}
