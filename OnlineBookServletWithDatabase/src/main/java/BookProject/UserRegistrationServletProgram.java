package BookProject;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;


@SuppressWarnings("serial")
@WebServlet("/reg")
public class UserRegistrationServletProgram extends HttpServlet {
	public int k =0;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserBean ub = new UserBean();
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		ub.setUname(req.getParameter("uname"));
		ub.setPword(req.getParameter("pword"));
		ub.setFname(req.getParameter("fname"));
		ub.setLname(req.getParameter("lname"));
		ub.setAddr(req.getParameter("addr"));
		ub.setMid(req.getParameter("mid"));
		ub.setPhno(req.getParameter("phno"));
		k = new UserRegistrationDAO().register(ub);
		if(k > 0) {
			pw.println("User Registration successfull...<br>");
		}else {
			pw.println("registration faild");
		}
		RequestDispatcher rd = req.getRequestDispatcher("login.html");
		rd.include(req, res);
	}
}
