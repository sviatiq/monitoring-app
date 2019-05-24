package server;


import DB.Config;
import client.Client;

import java.sql.*;

public class Monitoring extends Server {

        private static final String MONITORING = "INSERT INTO monitoring(" +
                "            site_url, site_status)" +
                "    VALUES (?, ?);";

       private static final String ADD_INFO = "INSERT INTO description(" +
               "            monitoring_period, response_code, response_line, response_size)" +
               "    VALUES (?, ?, ?, ?);";

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                Config.getProperty(Config.DB_URL),
                Config.getProperty(Config.DB_LOGIN),
                Config.getProperty(Config.DB_PASSWORD));
        return connection;
    }

        public Long saveInformation(Client client){
        Long result = -1L;
                try(Connection connection = getConnection();
                    PreparedStatement statement = connection.prepareStatement(MONITORING, new String[]{"site_id"})){

              statement.setString(2, client.getURL());
//              statement.setObject(3, );
//              statement.executeUpdate();

                    ResultSet rs = statement.executeQuery();
                    while(rs.next()){

                    }


            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
                return result;
        }
}
