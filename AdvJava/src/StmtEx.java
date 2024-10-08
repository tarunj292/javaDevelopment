import java.sql.*;

public class StmtEx {
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
            Statement stmt = con.createStatement();
            String sqlQuery = "SELECT * FROM table1";
            ResultSet rs = stmt.executeQuery(sqlQuery);
            while (rs.next()) {
                int tID = rs.getInt(1);
                String tName = rs.getString(2);
                String tCity = rs.getString(3);

                System.out.printf("ID: %d%nName: %s%nCity: %s%n", tID, tName, tCity);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
