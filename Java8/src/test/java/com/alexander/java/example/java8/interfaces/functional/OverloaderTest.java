package com.alexander.java.example.java8.interfaces.functional;

import org.junit.Test;

/**
 * Created by alexhopgood on 06/03/17.
 */
public class OverloaderTest {

    @Test
    public void testOverload(){
        Overloader overloader = new Overloader();

        overloader.overloadedMethod((x) -> true);
    }
}
