package BookProject;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static Connection con = null;
	private DBConnection() {}
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_operations","root","Mysql@0033");
			System.out.println("Connetion Created...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getcon() {
		return con;
	}
}
