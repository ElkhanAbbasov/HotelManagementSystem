package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateUsersTable {
    private static final String URL = "jdbc:sqlite:database.db";

    public static void main(String[] args) {
        String sql = "CREATE TABLE IF NOT EXISTS users ("
                   + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                   + "email TEXT UNIQUE NOT NULL, "
                   + "password TEXT NOT NULL)";
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Users table created or already exists.");
        } catch (Exception e) {
            System.out.println("Error creating users table:");
            e.printStackTrace();
        }
    }
}
