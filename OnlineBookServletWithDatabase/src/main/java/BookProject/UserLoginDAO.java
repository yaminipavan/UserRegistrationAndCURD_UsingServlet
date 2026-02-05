package BookProject;

import java.sql.*;
import jakarta.servlet.http.*;

public class UserLoginDAO {
	public UserBean ub = null;
	public UserBean Login(HttpServletRequest req) {
		try {
			Connection con = DBConnection.getcon();
			String uName = req.getParameter("uname");
			String pWord = req.getParameter("pword");
			PreparedStatement ps = con.prepareStatement("select * from RegisterUser where username=? and password=?");
			ps.setString(1, uName);
			ps.setString(2, pWord);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ub = new UserBean();
				ub.setUname(rs.getString(1));
				ub.setPword(rs.getString(2));
				ub.setFname(rs.getString(3));
				ub.setLname(rs.getString(4));
				ub.setAddr(rs.getString(5));
				ub.setMid(rs.getString(6));
				ub.setPhno(rs.getString(7));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ub;
	}

}
