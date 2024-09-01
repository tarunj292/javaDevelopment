import java.sql.*;

public class DB {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube", "root", "somaiya");
            Statement stmt = con.createStatement();
            ResultSet re = stmt.executeQuery("Select * from table1");
            ResultSetMetaData metaData = re.getMetaData();
            int columnCount = metaData.getColumnCount();
            System.out.println("Number of columns: " + columnCount);

            System.out.println("Column names:");
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                System.out.println(columnName);
            }
            while (re.next()) {
                System.out.println(re.getInt(1));
                System.out.println(re.getString(3));
                System.out.println(re.getString(2));
            }
            Statement stmt2 = con.createStatement();
            String mysqlQuery = "INSERT INTO table1 (tId, tName, tCity) VALUES(5,'Vaibhav','Udaipur')";
            stmt2.executeUpdate(mysqlQuery);

            String mysqlQuery2 = "INSERT INTO table1 (tId, tName, tCity) VALUES (?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(mysqlQuery2);
            pstmt.setInt(1, 6);
            pstmt.setString(2, "Shubham");
            pstmt.setString(3, "Sion");
            pstmt.executeUpdate();

            pstmt.close();
            stmt.close();
            stmt2.close();
            re.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}