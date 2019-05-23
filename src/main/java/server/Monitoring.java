package server;


import client.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class Monitoring extends Server {


    private static final String ADD_INFO = "INSERT INTO url_monitor(" +
            "            site_name, site_status, monitoring_period, http_response_code, " +
            "            http_response_line, http_response_size)" +
            "    VALUES (?, ?, ?, ?, " +
            "            ?, ?);";


    public static Connection getConnection() throws SQLException {
        return ConnectionBuilder.getConnection();
    }

        public static void saveInformation(Connection connection, Client c) throws SQLException{
            try(PreparedStatement statement = connection.prepareStatement(ADD_INFO)){
                try{
                    statement.setString(1,c.getURL());
                    statement.setObject(2,Server.status);
                    statement.setTime(3, java.sql.Time.valueOf(LocalTime.now()));
                    statement.setObject(4, c.getHTTPResponseCode());
                    statement.setObject(5, 2);
                    statement.setInt(6,2);
                }catch (SQLException ex){
                    ex.printStackTrace(System.out);
                }
            }
        }




}
