package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RateDB {
    public RateDB()
    {
        Connection conn = null;
    }
    public Rate selectRate (Rate rate) throws Exception {
        //Rate rate = new Rate();
        Connection conn = getConnection();
        try {

            Statement st = conn.createStatement();
            String query ="select * from Rate WHERE rateID = " + rate.getRateID();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                rate.setRateID(rs.getInt("rateID"));
                rate.setRate(rs.getInt("rate"));
                rate.setDescription(rs.getString("rateDescription"));
                rate.setStudent(rs.getBoolean("studentcheck"));
                rate.setValidDate(rs.getString("validDate"));
                rate.setExpirationDate(rs.getString("expirationDate"));
            }
            st.close();
            conn.close();
            return rate;

        }catch(Exception e) {
            System.out.println(e);
        }
        finally {
            if (conn != null)
                conn.close();
        }
        return null;

    }

    public static Connection getConnection() throws Exception{
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/cpp_parking_system";
        String username = "root";
        String password = "****";//password
        Class.forName(driver);

        Connection conn = DriverManager.getConnection(url, username, password);
        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        System.out.println(  "create connection called from " + st[2] );
        return conn;
    }
}
