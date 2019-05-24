import client.Client;
import server.HTTPResponse;
import server.URLStatus;

import java.time.LocalTime;

public class SaveClientsInfo{
    
    public static void main(String[] args) {
        buildClient();
        SaveClientsInfo sci = new SaveClientsInfo();
        System.out.println("Your URL: "+ checkURL(buildClient()));
        System.out.println("HTTP response: "+ checkHTTPCode(new HTTPResponse()));

        //Monitoring m = new Monitoring();
        //m.saveInformation(client);
    }

        public static Client buildClient() {
        Client client = new Client();
        client.setURL("localhost/1234");
        client.setConnectionNum(100);
        client.setTimeResponse(LocalTime.now());
        return client;
    }

        public static String checkURL (Client client){
            String url = "https://" + client.getURL();
            return url;
        }

        public static String checkHTTPCode (HTTPResponse http) {
        if (buildClient().getURL().equals("localhost/1234")) {
            http.setHttpCode(201);
            http.setHttpLine("Successful!");
            System.out.println("Your Status: " + checkNumConnections(buildClient()));
        }else{
            System.out.println(checkURL(buildClient()));
            http.setHttpCode(404);
            http.setHttpLine("NOT FOUND!");
        }
        return http.getHttpCode() + " " + http.getHttpLine();
    }

        public static Object checkNumConnections(Client client) {
            if (client.getConnectionNum() > 25) {
                client.setStatus(URLStatus.CRITICAL);
            } else if (client.getConnectionNum() >= 10 && client.getConnectionNum() <= 25) {
                client.setStatus(URLStatus.WARNING);
            } else {
                client.setStatus(URLStatus.OK);
            }
            return client.getStatus();
        }



    }
