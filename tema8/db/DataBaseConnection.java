package tema8.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection implements AutoCloseable {
    private static DataBaseConnection dbc;

    private static String url = "jdbc:mysql://localhost:3307/classicmodels?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
    private static String usuario = "root";
    private static String password = "root";

    private Connection con;

    private DataBaseConnection() throws SQLException {
        con = DriverManager.getConnection(url,usuario,password);
    }

    public Connection getConnection() {
        return con;
    }

    public static DataBaseConnection getInstance() throws SQLException {
        if (dbc == null){
            dbc = new DataBaseConnection();
        }

        return dbc;
    }

    @Override
    public void close() throws SQLException {
        if (con != null){
            con.close();
        }
    }
}
