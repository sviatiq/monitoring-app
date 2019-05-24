package client;

import server.URLStatus;

import java.time.LocalTime;

public class Client {

    private String URL;
    private int connectionNum;
    private URLStatus status;
    private LocalTime timeResponse;
    private int responseSize;

    public Client() {
    }

    public Client(int connectionNum) {
        this.connectionNum = connectionNum;
    }

    public Client(String URL) {
        this.URL = URL;
    }

    public Client(String URL, int connectionNum, LocalTime timeResponse) {
        this.URL = URL;
        this.connectionNum = connectionNum;
        this.timeResponse = timeResponse;
    }

    public String getURL() {
        return URL;
    }

    public URLStatus getStatus() {
        return status;
    }

    public void setStatus(URLStatus status) {
        this.status = status;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public int getConnectionNum() {
        return connectionNum;
    }

    public void setConnectionNum(int connectionNum) {
        this.connectionNum = connectionNum;
    }

    public LocalTime getTimeResponse() {
        return timeResponse;
    }

    public void setTimeResponse(LocalTime timeResponse) {
        this.timeResponse = timeResponse;
    }

    public int getResponseSize() {
        return responseSize;
    }

    public void setResponseSize(int responseSize) {
        this.responseSize = responseSize;
    }

    @Override
    public String toString() {
        return "Client{" +
                "URL='" + URL + '\'' +
                ", connectionNum=" + connectionNum +
                ", timeResponse=" + timeResponse +
                ", responseSize=" + responseSize +
                '}';
    }
}
