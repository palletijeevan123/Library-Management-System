package Connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
		
	
	public static Connection getConnection()  {
		Connection c=null;
	try {
	 String url="jdbc:mysql://localhost:3306/library";
	 String user="library";
	 String pass="jeevan@11";
		Class.forName("com.mysql.cj.jdbc.Driver");
		c=DriverManager.getConnection(url,user,pass);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return c;
		
	}
	
}
