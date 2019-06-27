package com.spartaglobal.Alpari;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private String apiKey;

    private Properties propRead = new Properties();

    public PropertiesReader(){
        try {
            propRead.load(new FileReader("resources/apikey.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        apiKey = propRead.getProperty("apikey");
    }

    public String getApiKey() {
        return apiKey;
    }
}
