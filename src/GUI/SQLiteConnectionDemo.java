package GUI;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLiteConnectionDemo {
    private static final String URL = "jdbc:sqlite:database.db";

    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC"); // Load SQLite driver
            Connection conn = DriverManager.getConnection(URL);
            if (conn != null) {
                System.out.println("Connected to SQLite database!");
            }
        } catch (Exception e) {
            System.out.println("Error connecting to SQLite database:");
            e.printStackTrace();
        }
    }
}
