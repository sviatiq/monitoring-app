
import server.HTTPResponse;
import server.Monitoring;

import static server.Server.*;


public class SaveClientsInfo {

    public static void main(String[] args) {
        System.out.println("Your URL: "+ checkURL(buildClient())); //for self control
        System.out.println("HTTP response: "+ checkHTTPRepsonse(new HTTPResponse())); //for self control

        Monitoring m = new Monitoring();
        m.saveInformation(buildClient());
        m.saveDescription();
    }





    }
