import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class JDBCDemo {

    public static void main(String[] args) {

        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            String url = "jdbc:mysql://localhost:3306/";
            String username = "root";
            String password = "new121314!";

            Connection conn =
                    DriverManager.getConnection(url, username, password);

            System.out.println("Connected to MySQL!");

            Statement stmt = conn.createStatement();

            String createDatabase =
                    "CREATE DATABASE IF NOT EXISTS StudentsDB";

            stmt.executeUpdate(createDatabase);
            System.out.println("Database created successfully.");

            stmt.executeUpdate("USE StudentsDB");

            String createTable =
                    "CREATE TABLE IF NOT EXISTS students (" +
                            "id INT AUTO_INCREMENT PRIMARY KEY, " +
                            "firstname VARCHAR(10), " +
                            "lastname VARCHAR(10), " +
                            "grade DOUBLE)";

            stmt.executeUpdate(createTable);
            System.out.println("Table created successfully.");

            String insert =
                    "INSERT INTO students (firstname, lastname, grade) " +
                            "VALUES ('Alemu', 'Kebede', 85.5)";

            int inserted = stmt.executeUpdate(insert);
            System.out.println(inserted + " row inserted.");

            String update =
                    "UPDATE students SET grade = 90 " +
                            "WHERE firstname = 'Alemu' AND lastname = 'Kebede'";

            int updated = stmt.executeUpdate(update);
            System.out.println(updated + " row updated.");

            String select = "SELECT * FROM students";

            ResultSet rs = stmt.executeQuery(select);

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("firstname") + " | " +
                                rs.getString("lastname") + " | " +
                                rs.getDouble("grade")
                );
            }

            rs.close();

            String delete =
                    "DELETE FROM students " +
                            "WHERE firstname = 'Alemu' AND lastname = 'Kebede'";

            int deleted = stmt.executeUpdate(delete);
            System.out.println(deleted + " row deleted.");
            stmt.close();
            conn.close();

            System.out.println("Connection closed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
