package com.spartaglobal.Alpari;

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
        rates = new RatesDTO("resources/rates.json");
    }

    @Test
    public void testSuccessResponse(){
        Assert.assertTrue(rates.getSuccessValue());
    }

    @Test
    public void testTimeline(){
        Assert.assertThat(rates.getTimeStampValue(), is(new SimpleDateFormat("MMM dd, yyyy H:mm:ss.SSS", Locale.ENGLISH)));
    }
}
