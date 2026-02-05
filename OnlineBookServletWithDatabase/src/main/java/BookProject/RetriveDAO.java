package BookProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class RetriveDAO {
	public ArrayList<BookBean> al = new ArrayList<BookBean>();
	
	public ArrayList<BookBean> RetriveBook() {
		try {
			Connection con = DBConnection.getcon();
			PreparedStatement ps = con.prepareStatement("select * from book");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BookBean bb = new BookBean();
				bb.setBcode(rs.getString(1));
				bb.setBname(rs.getString(2));
				bb.setBprice(rs.getFloat(3));
				bb.setBqty(rs.getInt(4));
				al.add(bb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	
}
