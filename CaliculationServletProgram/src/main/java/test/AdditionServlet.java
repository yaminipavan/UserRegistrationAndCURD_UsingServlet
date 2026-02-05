package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/ad")
public class AdditionServlet extends GenericServlet{

	public void init() throws ServletException{
		
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int v1 = Integer.parseInt(req.getParameter("v1")); 
		int v2 = Integer.parseInt(req.getParameter("v2"));
		int v3 = v1+v2;
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		pw.println("Sum result :"+v3);
		RequestDispatcher rd1 = req.getRequestDispatcher("input.html");
		rd1.include(req, res);
	}
	public void destroy() {
		
	}
}
