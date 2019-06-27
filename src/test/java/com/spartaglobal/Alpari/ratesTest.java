package com.spartaglobal.Alpari;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.hamcrest.core.Is.*;

public class ratesTest {
    private static RatesDTO rates;

    @BeforeClass //Before all test
    public static void setup(){
        RatesHTTPManager httpManager = new RatesHTTPManager();
        rates = new RatesDTO(httpManager.getLatestRates());
    }

    @Test
    public void testSuccessResponse(){
        Assert.assertTrue(rates.getSuccessValue());
    }

    @Test
    public void baseIsString() {
        Assert.assertTrue(rates.getBaseRateValue() instanceof String);
    }

    @Test
    public void testTimeStamMatchesDate(){
        Assert.assertEquals( rates.getDateValue().toString(), rates.getTimeStampValue());
    }

    @Test
    public void ratesIsEmbededJsonObject() {
        Assert.assertTrue(JSONObject.class.isInstance(rates.getRatesValue()));
    }

    @Test
    public void embededJSONValuesIsDouble() {
        Assert.assertTrue(Double.class.isInstance(rates.getSpecificRate("AED")));
    }
}
