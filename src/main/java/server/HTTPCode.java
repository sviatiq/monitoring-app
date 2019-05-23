package server;

import client.Client;

import java.util.*;

public class HTTPCode extends Client {

  private List<Integer> codeStatement = new ArrayList<>();


  static List creatingHTTPCodeResponse(List codeStatement){
      codeStatement.add(200); //success case
      codeStatement.add(400); //error case
      return codeStatement;
  }



}
