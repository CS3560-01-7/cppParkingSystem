/*
Class name: PaymentMethodDB.java
Contributers: Lynn Takahashi, Ethan Vazquez, Ly Rivera, Amal Anu, Sergey Hambardzumyan
Purpose: PaymentMethodDB used as a database accessor.
*/

import java.io.*;
import java.sql.*;
import java.util.*;

class PaymentMethodDB
{
     public static PaymentMethod deletePaymentMethod(Customer customer) {
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            String query = "DELETE FROM PaymentMethod WHERE broncoID = " + customer.getBroncoID();
            st.executeQuery(query);
            st.close();
            conn.close();
            return selectPaymentMethod(customer);

        }catch(Exception e) {
            System.out.println(e);

        }
        return null;

    }
    
    
    public static PaymentMethod addPaymentMethod(Customer customer)  throws Exception{

        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            String query = "INSERT INTO PaymentMethod  Values("+customer.getBroncoID()+","+customer.getPayment().getCardNumber()+","
                    +customer.getPayment().getSecurityCode()+","+customer.getPayment().getExpDateM()+","
                    +customer.getPayment().getExpDateY()+","+customer.getPayment().getFirstName()+","
                    +customer.getPayment().getLastName()+","+customer.getPayment().getBillingAddress()+")";
            st.executeQuery(query);
            st.close();
            conn.close();
            return selectPaymentMethod(customer);

        }catch(Exception e) {
            System.out.println(e);

        }
        return null;

    }
    
    public static PaymentMethod selectPaymentMethod(Customer customer) throws Exception
    {
        PaymentMethod paymentMethod = new PaymentMethod();
        try {
            Connection conn = getConnection();

            Statement st = conn.createStatement();
            String query ="select * from PaymentMethod WHERE broncoID = " + customer.getBroncoID();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                //Lynn please fix this part of the code. so broncoID does not make problem here as we talked today.
                paymentMethod.setCardNumber(rs.getLong("cardNumber"));
                paymentMethod.setSecurityCode(rs.getInt("securityCode"));
                paymentMethod.setExpDateM(rs.getInt("expirationDateMonth"));
                paymentMethod.setExpDateY(rs.getInt("expirationDateYear"));
                paymentMethod.setFirstName(rs.getString("firstName"));
                paymentMethod.setLastName(rs.getString("lastName"));
                paymentMethod.setBillingAddress(rs.getString("address"));


                return paymentMethod;
            }
            st.close();
            conn.close();

        }catch(Exception e) {System.out.println(e);}
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
