package com.spartaglobal.Alpari;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //RatesFileReader rates = new RatesFileReader("resources/rates.json");
        RatesDTO rates = new RatesDTO("resources/rates.json");
        //rates.printRates();
        System.out.println(rates.getSuccessValue());

    }
}
