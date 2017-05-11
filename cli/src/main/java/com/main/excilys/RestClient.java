package com.main.excilys;

import com.main.excilys.model.ComputerRest;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.internal.util.Base64;

public enum RestClient {
  INSTANCE;

  public static String doGet(String url) {
    return doGet(url, new HashMap<>());
  }

  public static String doGet(String url, Map<String, String> params) {
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    Client client = ClientBuilder.newClient();
    WebTarget webTarget = client.target("http://localhost:8080/ComputerDatabase").path(url);
    params.forEach((key, value) -> {
      webTarget.queryParam(key, value);
    });

    Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
    Response response = invocationBuilder.get();

    if (response.getStatus() != 200) {
      System.out.println(response);
      throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
    }

    return response.readEntity(String.class);
  }

  public static String doPost(String url, ComputerRest newComputerRest) {

    Client client = ClientBuilder.newClient();
    WebTarget webTarget = client.target("http://localhost:8080/ComputerDatabase").path(url);

    String authString = "test:cdb";
    String authStringEnc = new String(Base64.encode(authString.getBytes()));
    Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON)
        .property("Authorization", "Basic " + authStringEnc);
    System.out.println(Entity.json(newComputerRest));
    Response response = invocationBuilder.post(Entity.json(newComputerRest));

    if (response.getStatus() != 200) {
      System.out.println(response);
      throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
    }

    return response.readEntity(String.class);

  }

  public static String doPut(String url, ComputerRest updateComputerRest) {
    Client client = ClientBuilder.newClient();
    WebTarget webTarget = client.target("http://localhost:8080/ComputerDatabase").path(url);

    String authString = "test:cdb";
    String authStringEnc = new String(Base64.encode(authString.getBytes()));
    Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON)
        .property("Authorization", "Basic " + authStringEnc);
    Response response = invocationBuilder.put(Entity.json(updateComputerRest));

    if (response.getStatus() != 200) {
      System.out.println(response);
      throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
    }

    return response.readEntity(String.class);

  }

}
