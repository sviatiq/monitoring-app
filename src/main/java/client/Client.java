package client;


import server.HTTPCode;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Client {

    private String URL;
    private int connectionNum;
    private LocalTime timeResponse;
    private int responseSize;
    protected HTTPCode httpResponseCode;
    private List httpResponse;


    public Client() {
    }

    public Client(String URL) {
        this.URL = URL;
    }

    public Client(String URL, int connectionNum, LocalTime timeResponse) {
        this.URL = URL;
        this.connectionNum = connectionNum;
        this.timeResponse = timeResponse;
    }

    public int getResponseSize() {
        return responseSize;
    }

    public void setResponseSize(int responseSize) {
        this.responseSize = responseSize;
    }

    public int getConnectionNum() {
        return connectionNum;
    }

    public void setConnectionNum(int connectionNum) {
        this.connectionNum = connectionNum;
    }

    public HTTPCode getHTTPResponseCode() {
        return httpResponseCode;
    }

    public void setHTTPResponseCode(HTTPCode httpResponseCode) {
        if(httpResponseCode == null){
            httpResponse = new ArrayList(2);
        }
        httpResponse.add(httpResponseCode);

    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public int getConnectCounts() {
        return connectionNum;
    }

    public void setConnectCounts(int connectionNum) {
        this.connectionNum = connectionNum;
    }

    public LocalTime getTimeResponse() {
        return timeResponse;
    }

    public void setTimeResponse(LocalTime timeResponse) {
        this.timeResponse = timeResponse;
    }



}