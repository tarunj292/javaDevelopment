import java.sql.*;
import java.util.Scanner;

public class PstmtEx {
    public static void main(String args[]) {
        try {
            Scanner sc = new Scanner(System.in);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube", "root", "somaiya");
            String sqlQuery = "SELECT * FROM table1 where tName = ?";
            PreparedStatement pstmt = con.prepareStatement(sqlQuery);
            System.out.println("enter name");
            String tName = sc.nextLine();
            pstmt.setString(1, tName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String city = rs.getString(3);

                System.out.printf("ID: %d%nName: %s%nCity: %s%n", id, name, city);
            }
            rs.close();
            pstmt.close();
            con.close();
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}