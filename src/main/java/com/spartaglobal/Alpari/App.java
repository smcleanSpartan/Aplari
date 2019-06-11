package com.spartaglobal.Alpari;

import java.text.ParseException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParseException {
        //RatesFileReader rates = new RatesFileReader("resources/rates.json");
        RatesDTO rates = new RatesDTO("resources/rates.json");
        //rates.printRates();
        System.out.println(rates.getDateValue());

    }
}
