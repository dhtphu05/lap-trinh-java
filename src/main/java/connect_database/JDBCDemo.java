package connect_database;
import java.sql.*;
import javax.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {
        System.out.println("ket noi csdl");
        try{
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            String url = "jdbc:mysql://localhost:3306/qlsv";
            String user = "root";
            String password = "180723";
            Connection connection = DriverManager.getConnection(url, user, password);

            // Create a statement
            Statement statement = connection.createStatement();
            System.out.println("Connected to the database!");
            // Create a table
            String createTableSQL = "CREATE TABLE IF NOT EXISTS sinhvien (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50))";
            statement.executeUpdate(createTableSQL);
            // Insert data into the table
            String insertSQL = "INSERT INTO sinhvien (name) VALUES ('Nguyen Van A')";
            statement.executeUpdate(insertSQL);
            insertSQL = "INSERT INTO sinhvien (name) VALUES ('Nguyen Van B')";
            statement.executeUpdate(insertSQL);
            insertSQL = "INSERT INTO sinhvien (name) VALUES ('Nguyen Van C')";
            statement.executeUpdate(insertSQL);
            // Update data in the table
            // Execute a query
            String sql = "SELECT * FROM sinhvien";
            ResultSet resultSet = statement.executeQuery(sql);

            // Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Close the resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
