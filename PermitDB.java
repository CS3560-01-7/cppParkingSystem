
// The code should work
// only insert your connection password
package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PermitDB {

public static void addPermit(Permit permit)  throws Exception{
	Connection conn = getConnection();
        try {
            
            Statement st = conn.createStatement();
            String query = "INSERT INTO Permit (rateID,vin)  Values("+permit.getRateID()+",\'"+permit.getVIN()+"\')";
            st.executeUpdate(query);
            st.close();
            conn.close();
        }finally {
    	    if (conn != null) {
    	        conn.close();
    	    }
    	}
        

    }
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/cpp_parking_system";
            String username = "root";
            String password = "Lynn$anity11";//password
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, username, password);
            StackTraceElement[] st = Thread.currentThread().getStackTrace();
            System.out.println(  "create connection called from " + st[2] );
            return conn;

    }
}
