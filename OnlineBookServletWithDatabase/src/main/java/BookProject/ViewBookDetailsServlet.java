package BookProject;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/view1")
public class ViewBookDetailsServlet extends GenericServlet{

	public void init()throws ServletException {
		
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		ArrayList<BookBean> al = new RetriveDAO().RetriveBook();
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		if(al.size() == 0) {
			pw.println("Book not available...");
		}else {
			Iterator<BookBean> it = al.iterator();
			while(it.hasNext()) {
				BookBean bb = it.next();
				pw.println(bb.getBcode()+"\t"+bb.getBname()+"\t"+bb.getBprice()+"\t"+bb.getBqty()+"<br>");
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher("index.html");
		rd.include(req, res);
	}

	public void destroy() {
		//nocode
	}
}
