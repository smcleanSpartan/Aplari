package com.spartaglobal.Alpari;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ratesTest {
    static RatesDTO rates;

    @BeforeClass //Before all test
    public static void setup(){
        rates = new RatesDTO("resources/rates.json");
    }

    @Test
    public void testSuccessResponse(){
        Assert.assertTrue(rates.getSuccessValue());
    }
}
