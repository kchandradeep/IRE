package p1;

import java.sql.*;
import java.util.ArrayList;
public class Ex {

	public static void main(String[] args) throws SQLException {
		ArrayList<Float> impact = new ArrayList<Float>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vishal","vishal");
			if(con!=null)
			{
			Statement stm = con.createStatement();
			String query = "select impact_pct from auto_rating_factors where rating_factor_name = 'vehicleType' and option_desc = 'Petrol' or rating_factor_name = 'proof' and option_desc = 'yes' or rating_factor_name = 'class' and option_desc = 'transport' or rating_factor_name = 'safety' and option_desc = 'yes' or rating_factor_name = 'antiTheft' and option_desc = 'yes' or rating_factor_name = 'violation' and option_desc = 'yes' or rating_factor_name = 'policy' and option_desc = 'LongTerm'" ;
			ResultSet rs = stm.executeQuery(query);
			while(rs.next())
			{
				
				System.out.println(rs.getFloat(1));
				impact.add(rs.getFloat(1));
			
			}
			rs.close();
			con.close();
			
			}
			
			
		} 
		
	
		catch (Exception  e) {
		
			e.printStackTrace();
		}
		System.out.println(impact);
		
	}

}
