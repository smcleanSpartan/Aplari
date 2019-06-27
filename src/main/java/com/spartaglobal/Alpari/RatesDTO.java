package com.spartaglobal.Alpari;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;


public class RatesDTO {

    //JSONObject(HashMap) variable
    private JSONObject fullRatesFile;


    public RatesDTO(String filePath){
        //Creating an Instance of RatesFileReader with given file path.
//        RatesFileReader ratesFile = new RatesFileReader(filePath);

        //Creating an instance of JSONParser.
        JSONParser jParser = new JSONParser();

        try {

            //Using the JSONParser variable to put the contents of the file into an Object.
            Object ratesObj = jParser.parse(filePath);

            //Casting ratesObj(^above) to JSONObject variable.
            fullRatesFile = (JSONObject) ratesObj;
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    public void printRates(){
        //Printing contents of the JSONObject variable.
        System.out.println("rates.json contents: " + fullRatesFile.toString());
    }

    //Getting the Value of an Entry<K, V> from the JSONObject(HashMap) using its Key.

    public boolean getSuccessValue(){
        return (boolean) fullRatesFile.get("success");
    }

    public String getTimeStampValue(){
        //Converting/Casting the timestamp Entry to a long variable.
        long epoch = (long) fullRatesFile.get("timestamp");
        //Creating a Date instance using the timestamp(long) value.
        Date theDate = new Date(epoch *1000L);
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");

        return dateFormater.format(theDate);
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

    public double getSpecificRate(String rateCode){
        return (double) getRatesValue().get(rateCode);
    }

    public Set getAllRateKeys(){
        return getRatesValue().entrySet();
    }
}
