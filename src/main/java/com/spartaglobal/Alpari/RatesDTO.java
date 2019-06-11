package com.spartaglobal.Alpari;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class RatesDTO {

    private JSONObject fullRatesFile;

    public RatesDTO(String filePath){

        RatesFileReader ratesFile = new RatesFileReader(filePath);
        JSONParser jParser = new JSONParser();
        try {
            Object ratesObj = jParser.parse(ratesFile.getRatesfile());
            fullRatesFile = (JSONObject) ratesObj;
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }


    public void printRates(){
        System.out.println(fullRatesFile.toString());
    }

    public boolean getSuccessValue(){
        return (boolean) fullRatesFile.get("success");
    }

    /*public boolean getSuccessValue(){
        return (boolean) fullRatesFile.get("sucess");
    }*/
}
