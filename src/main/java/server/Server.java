package server;


import client.Client;

import java.time.LocalTime;


public class Server {

    //TODO Socket and info from Client
    private static final String HTTP = "https://";
    private static URLStatus status;
   // private static HTTPCode httpCode;

    //TODO На основе информации от клиента сделать проверку
    public static Client buildClient(){
        Client client = new Client();
        client.setURL("localhost/1234");
        client.setConnectCounts(1);
        client.setTimeResponse(LocalTime.of(12,4,21));
        HTTPCode httpCode = new HTTPCode();
        return client;
    }


    private static URLStatus checkNumConnections() {
        if(buildClient().getConnectCounts()>25){
            status = URLStatus.CRITICAL;
        }else if(buildClient().getConnectCounts()>=10 && buildClient().getConnectCounts()<=25) {
            status = URLStatus.WARNING;
        }else{
            status = URLStatus.OK;
        }
        return status;
    }

    private static URLStatus checkHTTPCode() {
      if(buildClient().getConnectCounts()>=1){
          buildClient().setHTTPResponseCode(201);
          status = URLStatus.OK;
      }else if(buildClient().getConnectCounts()<1){
          buildClient().setHTTPResponseCode(401);
          status = URLStatus.CRITICAL;
      }else{
          status = URLStatus.WARNING;
      }
    return status;
    }


    public static void main(String[] args) {

        System.out.println(HTTP + buildClient().getURL());
        System.out.println(buildClient().getConnectCounts());
        System.out.println("Your status: " + checkNumConnections());
        System.out.println("Your HTTP: " + checkHTTPCode());


    }
}
