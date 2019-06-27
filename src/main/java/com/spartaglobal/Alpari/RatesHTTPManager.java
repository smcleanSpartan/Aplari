package com.spartaglobal.Alpari;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class RatesHTTPManager {
    private String base_uri;
    private String access_key;

    public RatesHTTPManager() {
        //Creating instance of Properties reader to get the API access key
        PropertiesReader keyReader = new PropertiesReader();

        //Website/Location to manage data
        base_uri = "http://data.fixer.io/api";

        //Getting access key
        access_key = "access_key=" + keyReader.getApiKey();
    }

    public String getLatestRates() {
        String responseData = null;
        try {
            //Creates a client that closes when its finished running
            CloseableHttpClient httpClient = HttpClients.createDefault();

            //Setting up getting the latest rates data from the http call
            HttpGet getLatestRates = new HttpGet(base_uri + "/latest?" + access_key);

            //Storing the respose the the http client execution of the latest rates
            CloseableHttpResponse response = httpClient.execute(getLatestRates);

            //System.out.println(response.getAllHeaders());

            responseData = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseData;
    }
}
