package BookProject;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateBookServlet extends GenericServlet {

	public void init()throws ServletException { }
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		BookBean bb = new BookBean();
		bb.setBcode(req.getParameter("bcode"));
		bb.setBprice(Float.parseFloat(req.getParameter("bprice")));
		bb.setBqty(Integer.parseInt(req.getParameter("bqty")));
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		int k = new UpdateBookDAO().update(bb);
		if(k>0) {
			pw.println("Book Updated Successfully...<br>");
		}else {
			pw.println("not");
		}
		RequestDispatcher rd = req.getRequestDispatcher("index.html");
		rd.include(req, res);
	}

	public void destroy() { }
}
