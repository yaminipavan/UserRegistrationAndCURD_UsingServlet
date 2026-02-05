package BookProject;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookInsertDAO {

	public int k = 0;
	public int insert(BookBean bb) {
		try {
			Connection con = DBConnection.getcon();
			PreparedStatement ps = con.prepareStatement("insert into book values(?,?,?,?)");
			ps.setString(1, bb.getBcode());
			ps.setString(2, bb.getBname());
			ps.setFloat(3, bb.getBprice());
			ps.setInt(4, bb.getBqty());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
