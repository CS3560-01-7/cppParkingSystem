package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDB {

public Customer selectCustomer(Customer customer) throws Exception
{
	Connection con = getConnection();
	PreparedStatement statement = con.prepareStatement("SELECT firstName, lastName, emailAddress, address, checkStudent FROM Customer WHERE broncoID=" + customer.getBroncoID());
	try {
		
		ResultSet result = statement.executeQuery();
		
		while(result.next())
		{
			customer.setFirstName(result.getString("firstName"));
			customer.setLastName(result.getString("lastName"));
			customer.setEmailAddress(result.getString("emailAddress"));
			customer.setAddress(result.getString("address"));
			customer.setStudent(result.getBoolean("checkStudent"));
		}
		
		return customer;
	}catch(Exception e) {System.out.println(e);}
	finally {
	    if (con != null) {
	        con.close();
	    }
	}

	return null;
}

public static Connection getConnection() throws Exception
{
	
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/cpp_parking_system";//jdbc:mysql://portNumber/databseName
		String username = "root";
		String password = "Lynn$anity11";
		Class.forName(driver);
		
		Connection conn = DriverManager.getConnection(url, username, password);
		StackTraceElement[] st = Thread.currentThread().getStackTrace();
	    System.out.println(  "create connection called from " + st[2] );
		//System.out.println("Connected");
		return conn;
		
}
}

