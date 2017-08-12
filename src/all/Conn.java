package all;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn 
{
	static Connection con;
	static Statement st;
	
	static
	{
		try 
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","12345");
			st = con.createStatement();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
