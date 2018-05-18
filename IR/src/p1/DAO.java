
package p1;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


public class DAO {
	public static int getModel(String car)
	{
		int base = 0 ;
		//HashMap<String,Float> m = new HashMap<String,Float>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vishal","vishal");
			if(con!=null)
			{
			Statement stm = con.createStatement();
			String query = "select Auto_Base_Premium from auto_rates where vehicle_model_name = '" + car + "'" ;
			ResultSet rs = stm.executeQuery(query);
			while(rs.next())
			{
				
				base =  (int) rs.getFloat(1);
			
			}
			rs.close();
			con.close();
			
			}
		} 
		
	
		catch (Exception  e) {
		
			e.printStackTrace();
		}
		return base; 
		
		
		
	}
	public  ArrayList<String> selectModel() 
	{
		ArrayList<String> models = new ArrayList<String>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vishal","vishal");
			if(con!=null)
			{
			Statement stm = con.createStatement();
			String query = "select vehicle_model_name from auto_rates";
			ResultSet rs = stm.executeQuery(query);
			while(rs.next())
			{
				
				models.add(rs.getString(1));
			
			}
			rs.close();
			con.close();
			
			}
		} 
		
	
		catch (Exception  e) {
		
			e.printStackTrace();
		}
		return models;
		
	}

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
