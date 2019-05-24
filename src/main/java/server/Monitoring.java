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
            return ConnectionBuilder.getConnection();
        }

        public void saveInformation(Client client){
            try(Connection connection = getConnection();
                    PreparedStatement statement = connection.prepareStatement(MONITORING)){

                statement.setString(1, checkURL(buildClient()));
                statement.setString(2, checkNumConnections(buildClient()).toString());

                statement.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        public void saveDescription(){
            try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(ADD_INFO)){

                statement.setTime(1, java.sql.Time.valueOf(buildClient().getTimeResponse()));
                statement.setInt(2, 201);
                statement.setString(3, checkHTTPRepsonse(new HTTPResponse()));
                statement.setString(4, "234");


                statement.executeUpdate();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
}
