package test;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/mu")
public class MultiplicationServlet extends GenericServlet {

public void init() throws ServletException{
		
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int v1 = Integer.parseInt(req.getParameter("v1")); 
		int v2 = Integer.parseInt(req.getParameter("v2"));
		int v3 = v1*v2;
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		pw.println("Multiplication result :"+v3);
		
		RequestDispatcher rd = req.getRequestDispatcher("input.html");
		rd.include(req, res);
	}
	public void destroy() {
		
	}
}
