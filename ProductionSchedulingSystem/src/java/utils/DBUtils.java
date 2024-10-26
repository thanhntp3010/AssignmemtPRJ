package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    private static final String DB = "ProductionSchedulingSystem_DB";
    private static final String USER_NAME = "sa";
    private static final String PASSWORD = "sa";

    public static Connection getConnection1() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://DESKTOP-UKNEQC5:1433;databaseName=" + DB+ ";encrypt=true;trustServerCertificate=true";
        conn = DriverManager.getConnection(url, USER_NAME, PASSWORD);
        return conn;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println(getConnection1().toString());
    }

}
