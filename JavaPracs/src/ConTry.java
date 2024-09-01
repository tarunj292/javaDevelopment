import java.sql.*;

public class ConTry {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube", "root", "somaiya");
            if (con.isClosed()) {
                System.out.println("Close");
            } else {
                System.out.println("Open");
            }
            Statement stmt = con.createStatement();
            String sqlQuery = "SELECT * FROM table1";
            ResultSet re = stmt.executeQuery(sqlQuery);
            while (re.next()) {
                System.out.println(re.getInt(1));
                System.out.println(re.getString(2));
                System.out.println(re.getString(3));
            }
            re.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
