package BookProject;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;


@SuppressWarnings("serial")
@WebServlet("/book")
public class AddBooServlet extends GenericServlet {

	public void init()throws ServletException {
		
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		BookBean bb = new BookBean();
		bb.setBcode(req.getParameter("bcode"));
		bb.setBname(req.getParameter("bname"));
		bb.setBprice(Float.parseFloat(req.getParameter("bprice")));
		bb.setBqty(Integer.parseInt(req.getParameter("bqty")));
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		int k = new BookInsertDAO().insert(bb);
		
		if(k>0) {
			pw.println("Book Inserted successfully...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.include(req, res);
		}
	}

	public void destroy() {
		//nocode
	}
}

