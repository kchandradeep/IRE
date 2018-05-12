package p1;

import java.sql.*;
public class Ex {

	public static void main(String[] args) throws SQLException {
		
	
		String userID = "admin";
		String password = "admin";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("no class");
			e.printStackTrace();
		}
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vishal","vishal");
		Statement stm = con.createStatement();
		String query = "select * from Underwriter";
		ResultSet rs = stm.executeQuery(query);
		while(rs.next())
		{
			System.out.println(rs.getString(1));
			
		}
		con.close();
	}

}
