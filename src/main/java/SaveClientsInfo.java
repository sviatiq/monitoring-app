
import server.HTTPResponse;
import server.Monitoring;

import static server.Server.*;


public class SaveClientsInfo {

    public static void main(String[] args) {
        buildClient();
        SaveClientsInfo sci = new SaveClientsInfo();
        System.out.println("Your URL: "+ checkURL(buildClient()));
        System.out.println("HTTP response: "+ checkHTTPCode(new HTTPResponse()));

        Monitoring m = new Monitoring();
        m.saveInformation(buildClient());
    }





    }
