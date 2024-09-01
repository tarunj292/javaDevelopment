import java.sql.*;

public class ConEx {
    public static void main(String[] args) {
        try {
            // Register the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Create the connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube", "root", "somaiya");
            if (con.isClosed()) {
                System.out.println("not connected");
            } else {
                System.out.println("Connected");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
