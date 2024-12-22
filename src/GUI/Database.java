package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {
    private static final String URL = "jdbc:sqlite:database.db";

    static {
        initializeDatabase(); // Automatically run this when the class is loaded
    }

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void initializeDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS users ("
                   + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                   + "email TEXT UNIQUE, "
                   + "password TEXT NOT NULL)";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            if (conn != null) {
                stmt.execute(sql);
                System.out.println("Checked database: 'users' table exists or has been created.");
            }
        } catch (Exception e) {
            System.out.println("Error initializing database:");
            e.printStackTrace();
        }
    }

    public static boolean registerUser(String email, String password) {
        String sql = "INSERT INTO users(email, password) VALUES(?, ?)";
        try (Connection conn = connect();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error registering user:");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean loginUser(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (Connection conn = connect();
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            java.sql.ResultSet rs = pstmt.executeQuery();
            return rs.next(); // Returns true if a user is found
        } catch (Exception e) {
            System.out.println("Error logging in:");
            e.printStackTrace();
            return false;
        }
    }
}
