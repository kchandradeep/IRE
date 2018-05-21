
package p1;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


public class DAO {
	public static Float getImpactPct(String vehicleType,String proof,String dClass,String safety,String antiTheft,String violation,String policy,int base)
	{
		float total = 0.0f;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vishal","vishal");
			if(con!=null)
			{
			Statement stm = con.createStatement();
			String query = "select impact_pct,impact_type from auto_rating_factors where rating_factor_name = 'vehicleType' and option_desc = '" + vehicleType + "' or rating_factor_name = 'proof' and option_desc = '" + proof + "' or rating_factor_name = 'class' and option_desc = '" + dClass + "' or rating_factor_name = 'safety' and option_desc = '" + safety +"' or rating_factor_name = 'antiTheft' and option_desc = '" + antiTheft +  "' or rating_factor_name = 'violation' and option_desc = '"+ violation + "' or rating_factor_name = 'policy' and option_desc = '" + policy + "'" ;
			ResultSet rs = stm.executeQuery(query);
			while(rs.next())
			{
				 float f = base*rs.getFloat(1);
				
				if(rs.getInt(2) == 0)
				{
					total -= f;
				}
				else
					total += f;
			
			}
			rs.close();
			con.close();
			
			}
			
			
		} 
		
	
		catch (Exception  e) {
		
			e.printStackTrace();
		}
		
		
		return total;
	}
	
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
