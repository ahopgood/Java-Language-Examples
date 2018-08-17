package com.alexander.java.examples.java7;

import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Currency;
import java.util.Locale;

public class CurrencyUsage {
    @Test
    public void currencyDemo() {
        File file = new File("");
        file.getAbsolutePath();

        //Override the currency.data in the JRE/lib directory with values of your own choosing
        Path libFolder = Paths.get(file.getAbsolutePath(), "src","test", "resources", this.getClass().getPackage().getName().replace(".", File.separator));
        System.out.println(libFolder);
        System.setProperty("java.home", libFolder.toString());

        Currency currency = Currency.getInstance(Locale.UK);
        System.out.println(currency.getDisplayName() + " " + currency.getSymbol() + " " + currency.getCurrencyCode());
    }
}
