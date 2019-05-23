package server;

import client.Client;

import java.util.*;

public class HTTPCode extends Client {

    private String httpLine;
    private int httpCode;

    public HTTPCode(){};

    public HTTPCode(int httpCode){
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
        return "HTTPCode{" +
                "httpLine='" + httpLine + '\'' +
                ", httpCode=" + httpCode +
                '}';
    }
}
