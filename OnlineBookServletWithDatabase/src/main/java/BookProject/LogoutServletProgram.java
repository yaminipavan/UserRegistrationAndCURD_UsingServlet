package BookProject;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServletProgram extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw = res.getWriter();
		 res.setContentType("text/html");
		 
		 Cookie[] ck = req.getCookies();
		 
		 if(ck==null) {
			 pw.println("Session Expired....<br>");
		 }else {
			ck[0].setMaxAge(0);
			 pw.println("User Loggedout Successfully...<br>");
		}
		 RequestDispatcher rd= req.getRequestDispatcher("login.html");
		 rd.include(req, res);
	}
}
