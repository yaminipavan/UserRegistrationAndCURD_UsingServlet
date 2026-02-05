package BookProject;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteBookDAO {
	public int k = 0;
	public int Delete(BookBean bb) {
		try {
			Connection con = DBConnection.getcon();
			PreparedStatement ps = con.prepareStatement("delete from book where bcode=?");
			ps.setString(1, bb.getBcode());
			k = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
