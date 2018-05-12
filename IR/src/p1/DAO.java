
package p1;
import java.sql.*;


public class DAO {

	public static UserBean isUser(String userID,String password) throws SQLException
	{
		
		UserBean details = new UserBean();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("no class");
			e.printStackTrace();
		}
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vishal","vishal");
		if(con!=null)
		{
		Statement stm = con.createStatement();
		String query = "select role,username from Underwriter where userid= '" + userID + "' and password = '" + password + "'";
		ResultSet rs = stm.executeQuery(query);
		while(rs.next())
		{
			details.setRole(rs.getString(1));
			details.setUserName(rs.getString(2));
		}
		
		}
		else
			System.out.println("djfkldfj");
		return details;
	}
}
