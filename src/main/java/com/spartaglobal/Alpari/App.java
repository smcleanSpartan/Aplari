package com.spartaglobal.Alpari;

import java.text.ParseException;

public class App 
{
    public static void main( String[] args ) {

        RatesDTO rates = new RatesDTO("resources/rates.json");
        rates.printRates();
        System.out.println(rates.getAllRateKeys());
        System.out.println(rates.getSpecificRate("AED"));

    }
}
