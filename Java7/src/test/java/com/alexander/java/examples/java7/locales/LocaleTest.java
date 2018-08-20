package com.alexander.java.examples.java7.locales;

import org.junit.Test;

import java.awt.*;
import java.util.Currency;
import java.util.Locale;

public class LocaleTest {

    @Test
    public void localeDefault_usesDisplay(){
        //Defaults to Display (e.g. currency, date and number formatting)
        Locale.setDefault(Locale.CANADA_FRENCH);

        Currency currency = Currency.getInstance(Locale.getDefault());
        System.out.println(currency.getSymbol());
        System.out.println(currency.getDisplayName());
    }

    @Test
    public void locale_setDisplay(){
        Locale.setDefault(Locale.Category.DISPLAY, Locale.CANADA_FRENCH);

        Currency currency = Currency.getInstance(Locale.getDefault());
        System.out.println(currency.getSymbol());
        System.out.println(currency.getDisplayName());
    }

    @Test
    public void locale_setFormat(){
        Locale.setDefault(Locale.Category.FORMAT, Locale.ENGLISH);

        System.out.println(Locale.getDefault(Locale.Category.FORMAT).getDisplayCountry());
        System.out.println(Locale.getDefault(Locale.Category.FORMAT).getDisplayLanguage());

    }

}
