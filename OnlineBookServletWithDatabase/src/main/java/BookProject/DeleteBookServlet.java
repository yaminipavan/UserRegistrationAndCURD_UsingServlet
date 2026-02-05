package BookProject;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteBookServlet extends GenericServlet{

public void init()throws ServletException {
		
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		BookBean bb = new BookBean();
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		bb.setBcode(req.getParameter("bcode"));
		int k = new DeleteBookDAO().Delete(bb);
		if(k>0) {
			pw.println("Book deleted successfully by bookId..."+bb.getBcode()+"<br>");
		}
		RequestDispatcher rd = req.getRequestDispatcher("index.html");
		rd.include(req, res);
	}

	public void destroy() {
		//nocode
	}
}
