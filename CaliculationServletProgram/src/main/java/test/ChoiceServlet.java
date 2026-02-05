package test;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/choice")
public class ChoiceServlet extends GenericServlet {

	public void init() throws ServletException{
		
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String ch =  req.getParameter("s1");
		switch (ch) {
		case "Add": {
			RequestDispatcher rd = req.getRequestDispatcher("ad");
			rd.forward(req, res);
		}
		case "Sub": {
			RequestDispatcher rd = req.getRequestDispatcher("su");
			rd.forward(req, res);
		}
		case "Mul": {
			RequestDispatcher rd = req.getRequestDispatcher("mu");
			rd.forward(req, res);
		}
		case "Div": {
			RequestDispatcher rd = req.getRequestDispatcher("div");
			rd.forward(req, res);
		}
		case "Mod": {
			RequestDispatcher rd = req.getRequestDispatcher("mod");
			rd.forward(req, res);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + ch);
		}
		
	}
	public void destroy() {
		
	}
	
}
