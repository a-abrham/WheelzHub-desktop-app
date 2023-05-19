package DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBhandler extends config {
    Connection dbconnection;

    public Connection getConnection() throws SQLException {
        String connectionString = "jdbc:mysql://" + config.dbhost + ":" + config.dbport + "/" + config.dbname
                + "?autoReconnect=true&useSSL=false";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        dbconnection = DriverManager.getConnection(connectionString, config.duser, config.dpassword);

        return dbconnection;
    }
}
