package com.alexander.java.example.java6;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by alexhopgood on 30/01/17.
 */
public class BitwiseOperatorsTest {

    BitwiseOperators operators = new BitwiseOperators();

    @Before
    public void setup(){

    }

    @Test
    public void testInvertBitPattern_allOnes() throws Exception {
        String allOnes = "1111";
        String inverse = operators.invertBitPattern(allOnes);
        assertEquals("0000", operators.cropToInputMagnitude(allOnes, inverse));

    }

    @Test
    public void testInvertBitPattern_allZeros() throws Exception {
        String allZeros = "0000";
        String inverse = operators.invertBitPattern(allZeros);
        assertEquals("1111", operators.cropToInputMagnitude(allZeros, inverse));
    }

    @Test
    public void testInvertBitPattern_mixed() throws Exception {
        String allZeros = "0101";
        String inverse = operators.invertBitPattern(allZeros);
        assertEquals("1010", operators.cropToInputMagnitude(allZeros, inverse));
    }

    @Test
    public void testXorBitPatterns_allZeros(){
        String allZeros = "0000";
        assertEquals("0", operators.xorBitPatterns(allZeros, allZeros));
    }

    @Test
    public void testXorBitPatterns_allOnes(){
        String allOnes = "1111";
        assertEquals("0", operators.xorBitPatterns(allOnes, allOnes));
    }

    @Test
    public void testXorBitPatterns_onesXorWithZeros(){
        String allOnes = "1111";
        String allZeros = "0000";
        assertEquals("1111", operators.xorBitPatterns(allOnes, allZeros));
    }


    @Test
    public void testXorBitPatterns_mixedXorWithZeros(){
        String mixed = "1010";
        String allZeros = "0000";
        assertEquals("1010", operators.xorBitPatterns(mixed, allZeros));
    }

    @Test
    public void testXorBitPatterns_mixedXorWithOnes(){
        String mixed = "1010";
        String allZeros = "1111";
        assertEquals("1010", operators.xorBitPatterns(mixed, allZeros));
    }

    @Test
    public void testXorBitPatterns_mixedXorWithMixed(){
        String allOnes = "1010";
        String allZeros = "0101";
        assertEquals("1111", operators.xorBitPatterns(allOnes, allZeros));

        assertEquals("0", operators.xorBitPatterns("1010", "1010"));

        assertEquals("100", operators.xorBitPatterns("1010", "1110"));

    }

    @Test
    public void testAndBitPatterns_OrderOfMagnitude(){
        String allOnes = "0111";
        String allZeros = "0001";
        assertEquals("1000", operators.andBitPattern(allOnes, allZeros));
    }

    @Test
    public void testAndBitPatterns_(){
        String allOnes = "0000";
        String allZeros = "0001";
        assertEquals("0001", operators.andBitPattern(allOnes, allZeros));
    }

    @Test
    public void testAndBitPatterns_(){
        String allOnes = "0101";
        String allZeros = "1010";
        assertEquals("1000", operators.andBitPattern(allOnes, allZeros));
    }

}