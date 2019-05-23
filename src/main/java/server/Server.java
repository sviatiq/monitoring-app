package server;


import client.Client;

import java.time.LocalTime;


public class Server {

    //TODO Socket and info from Client
    private static final String HTTP = "https://";
    private static URLStatus status;

    //TODO На основе информации от клиента сделать проверку
    public static Client buildClient(){
        Client client = new Client();
        client.setURL("localhost/1234");
        client.setConnectCounts(12);
        client.setTimeResponse(LocalTime.of(12,4,21));

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

    private static void checkHTTPCode() {
       if(buildClient().)


    }


    public static void main(String[] args) {

        System.out.println(HTTP+buildClient().getURL());
        System.out.println("Your status: "+checkNumConnections());

    }

}
