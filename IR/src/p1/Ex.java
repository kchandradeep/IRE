package p1;

import java.sql.*;
import java.util.ArrayList;
public class Ex {

	public static void main(String[] args) throws SQLException {
		
		ArrayList<String> models=new DAO().selectModel();
		System.out.println(models.size());
	}

}
