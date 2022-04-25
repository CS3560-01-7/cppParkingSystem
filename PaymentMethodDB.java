/*
Class name: PaymentMethodDB.java
Contributers: Lynn Takahashi, Ethan Vazquez, Ly Rivera, Amal Anu, Sergey Hambardzumyan
Purpose: PaymentMethodDB used as a database accessor.
*/

import java.io.*;
import java.util.*;

class PaymentMethodDB
{
public static Connection getConnection() throws Exception
{
	try {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/cpp_parking_system";//replace with your own
		String username = "";//for sql
		String password = "";//for sql
		Class.forName(driver);
		
		Connection conn = DriverManager.getConnection(url, username, password);
		System.out.println("Connected");
		
		return conn;
	}catch (Exception e) {System.out.println(e);}
	
	return null;
}
}
