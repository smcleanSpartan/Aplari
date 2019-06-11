package com.spartaglobal.Alpari;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;


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

    public Date getTimeStampValue(){
        long epoch = (long) fullRatesFile.get("timestamp");
        return new Date(epoch * 1000);
    }

    public String getBaseRateValue(){
        return (String) fullRatesFile.get("base");
    }

    public LocalDate getDateValue() {
        String sDate = (String) fullRatesFile.get("date");
        LocalDate newDate = LocalDate.parse(sDate);
        return newDate;
    }

    public JSONObject getRatesValue(){
        return (JSONObject) fullRatesFile.get("rates");
    }

    /*public boolean getSuccessValue(){
        return (boolean) fullRatesFile.get("sucess");
    }*/
}
