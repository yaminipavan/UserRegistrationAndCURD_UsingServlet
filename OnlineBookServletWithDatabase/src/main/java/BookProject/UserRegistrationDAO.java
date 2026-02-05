package BookProject;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserRegistrationDAO {
	public int k =0;
	public int register(UserBean ub) {
		try {
			Connection con = DBConnection.getcon();
			PreparedStatement ps = con.prepareStatement("insert into RegisterUser values(?,?,?,?,?,?,?)");
			ps.setString(1, ub.getUname());
			ps.setString(2, ub.getPword());
			ps.setString(3, ub.getFname());
			ps.setString(4, ub.getLname());
			ps.setString(5, ub.getAddr());
			ps.setString(6, ub.getMid());
			ps.setString(7, ub.getPhno());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

	
}
