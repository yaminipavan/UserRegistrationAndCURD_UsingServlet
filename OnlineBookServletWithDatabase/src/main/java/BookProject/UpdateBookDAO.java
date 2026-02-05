package BookProject;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateBookDAO {
	public int k = 0;
	public int update(BookBean bb) {
		try {
			Connection con = DBConnection.getcon();
			PreparedStatement ps = con.prepareStatement("update book set bprice=?,bqty=? where bcode=?");
			ps.setFloat(1, bb.getBprice());
			ps.setInt(2, bb.getBqty());
			ps.setString(3, bb.getBcode());
			k = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
