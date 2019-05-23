package client;


import java.time.LocalTime;

public class Client {

    private String URL;
    private int connectionNum;
    private LocalTime timeResponse;
    private int responseSize;
    private int HTTPResponseCode;

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

    public int getHTTPResponseCode() {
        return HTTPResponseCode;
    }

    public void setHTTPResponseCode(int HTTPResponseCode) {
        this.HTTPResponseCode = HTTPResponseCode;
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
