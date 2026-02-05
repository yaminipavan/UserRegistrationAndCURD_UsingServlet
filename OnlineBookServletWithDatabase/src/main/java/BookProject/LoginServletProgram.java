package BookProject;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServletProgram extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	UserBean ub = new UserLoginDAO().Login(req);
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		if(ub == null) {
			pw.println("Invalid UserName or Password try Again...<br>");
			RequestDispatcher rd= req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}else {
			Cookie ck = new Cookie("fname", ub.getFname());
			res.addCookie(ck);//Adding Cookie to response
			pw.println("Welcome User "+ub.getFname()+"<br>");
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.include(req, res);
			
		}
	}	
}
	
