package utill;

import javax.naming.*;
import javax.sql.*;
import java.sql.*;

public class DBUtil extends SQLException{
    public static Connection conn;
    public static Connection getConection() throws SQLException {
        try {
            Context initContext = null;
            initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/UsersDB");
            conn = ds.getConnection();
        }
        catch (NamingException e){
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeConectin(Connection conn){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
