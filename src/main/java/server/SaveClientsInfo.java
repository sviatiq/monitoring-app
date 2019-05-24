package server;

import client.Client;
import server.HTTPResponse;
import server.Monitoring;
import server.URLStatus;

import java.time.LocalTime;


public class SaveClientsInfo  {

    public static void main(String[] args) {
        System.out.println("Your URL: " + checkURL(buildClient())); //for self control
        System.out.println("HTTP response: " + checkHTTPRepsonse(new HTTPResponse())); //for self control
        System.out.println("Your Status: " + checkNumConnections(buildClient()));

        Monitoring m = new Monitoring();
        m.saveInformation(buildClient());
        m.saveDescription();
    }

        public static Client buildClient() {
            Client client = new Client();
            client.setURL("localhost:1234");
            client.setConnectionNum(10);
            client.setTimeResponse(LocalTime.now());
            return client;
        }

        public static String checkURL(Client client) {
            String url = "https://" + client.getURL();
            return url;
        }

        //TODO: add http.setHttpCode
        public static String checkHTTPRepsonse(HTTPResponse http) {

            if (buildClient().getURL().equals("localhost:1234")) { //must be for any address
                http.setHttpCode(201);
                http.setHttpLine("Successful!"); //optional, depends on what code will be
                return http.getHttpLine();
            } else {
                http.setHttpCode(404);
                http.setHttpLine("NOT FOUND!");
                return http.getHttpLine();
            }
        }

        public static Object checkNumConnections(Client client) {
            if (client.getConnectionNum() >= 25) {
                client.setStatus(URLStatus.CRITICAL);
            } else if (client.getConnectionNum() >= 15 && client.getConnectionNum() <= 25) {
                client.setStatus(URLStatus.WARNING);
            } else {
                client.setStatus(URLStatus.OK);
            }
            return client.getStatus();
        }
}
