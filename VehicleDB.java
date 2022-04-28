import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VehicleDB {

    public static Vehicle deleteVehicle(Customer customer) {
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            String query = "DELETE FROM Vehicle WHERE broncoID = " + customer.getBroncoID();
            st.executeQuery(query);
            st.close();
            conn.close();
            return selectVehicle(customer);

        }catch(Exception e) {
            System.out.println(e);

        }
        return null;

    }

    public static Vehicle addVehicle(Customer customer) {
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            String query = "INSERT INTO Vehicle  Values("+customer.getVehicle().getVIN()+","+customer.getBroncoID()+","
                    +customer.getVehicle().getLicensePlate()+","+customer.getVehicle().getVehicleType()+","
                    +customer.getVehicle().getVehicleMake()+","+customer.getVehicle().getVehicleColor()+","
                    +customer.getVehicle().getModelYear()+","+customer.getVehicle().getState()+")";
            st.executeQuery(query);
            st.close();
            conn.close();
            return selectVehicle(customer);

        }catch(Exception e) {
            System.out.println(e);

        }
        return null;
    }

    public static Vehicle selectVehicle(Customer customer) throws Exception {
        Vehicle vehicle = new Vehicle();
        try {
            Connection conn = getConnection();

            Statement st = conn.createStatement();
            String query ="select * from Vehicle WHERE broncoID = " + customer.getBroncoID();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                vehicle.setVin(rs.getString("vin"));
                rs.getInt("broncoID");
                vehicle.setLicensePlate(rs.getString("licensePlate"));
                vehicle.setVehicleType(rs.getString("vehicleType"));
                vehicle.setVehicleMake(rs.getString("vehicleMake"));
                vehicle.setVehicleColor(rs.getString("vehicleColor"));
                vehicle.setModelYear(rs.getInt("vehicleYear"));
                vehicle.setState(rs.getString("state"));

            }
            st.close();
            conn.close();
            return vehicle;

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
