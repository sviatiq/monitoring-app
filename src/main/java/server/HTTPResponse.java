package server;

import client.Client;


public class HTTPResponse extends Client {

    private String httpLine;
    private int httpCode;
    private int responseSize;

    public HTTPResponse(){};

    public HTTPResponse(int httpCode){
        this.httpCode = httpCode;

    }

    public String getHttpLine() {
        return httpLine;
    }

    public void setHttpLine(String httpLine) {
        this.httpLine = httpLine;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    @Override
    public String toString() {
        return "HTTPResponse{" +
                "httpLine='" + httpLine + '\'' +
                ", httpCode=" + httpCode +
                '}';
    }
}
