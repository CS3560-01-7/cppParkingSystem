/*
Class name: RateDB.java
Contributers: Lynn Takahashi, Ethan Vazquez, Ly Rivera, Amal Anu, Sergey Hambardzumyan
Purpose: RateDB used as a database accessor.
*/


import application.Rate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RateDB {
    public static Rate selectRate (int rateID) {
        Rate rate = new Rate();
        try {
            Connection conn = getConnection();

            Statement st = conn.createStatement();
            String query ="select * from Rate WHERE rateID = " + rateID;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                rs.getInt("rateID");
                rate.setRate(rs.getInt("rate"));
                rate.setRateDescription(rs.getString("rateDescription"));
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
        return null;

    }

    public static Connection getConnection() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/cpp_parking_system";
            String username = "root";
            String password = "****";//password
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;

    }
}
