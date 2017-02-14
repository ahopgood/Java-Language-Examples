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
        assertEquals("101", operators.xorBitPatterns(mixed, allZeros));
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
        String allZeros = "0111";
        assertEquals("111", operators.andBitPattern(allOnes, allZeros));
    }

    @Test
    public void testAndBitPatterns_zeroBits(){
        String allOnes = "1000";
        String allZeros = "0001";
        assertEquals("0", operators.andBitPattern(allOnes, allZeros));
    }

    @Test
    public void testAndBitPatterns_alternateBits(){
        String allOnes = "1111";
        String allZeros = "1010";
        assertEquals("1010", operators.andBitPattern(allOnes, allZeros));
    }

    @Test
    public void testOrBitPatterns_OrderOfMagnitude(){
        String allOnes = "1111";
        String allZeros = "0001";
        assertEquals("1111", operators.orBitPattern(allOnes, allZeros));
    }

    @Test
    public void testOrBitPatterns_zeroBits(){
        String allOnes = "0000";
        String allZeros = "0001";
        assertEquals("1", operators.orBitPattern(allOnes, allZeros));
    }

    @Test
    public void testOrBitPatterns_alternateBits(){
        String allOnes = "0101";
        String allZeros = "1010";
        assertEquals("1111", operators.orBitPattern(allOnes, allZeros));
    }

    @Test
    public void testSignedLeftShiftPattern_allOnesShiftByOne(){
        String allOnes = "1111";
        assertEquals("11110", operators.signedLeftShiftPattern(allOnes, 1));
    }

    @Test
    public void testSignedLeftShiftPattern_allZerosShiftByOne(){
        String allOnes = "0000";
        assertEquals("0", operators.signedLeftShiftPattern(allOnes, 1));
    }

    @Test
    public void testSignedRightShiftPattern_negativeNumber_minus1(){
        String minusOneInBinary = "-0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"001";
        assertEquals("11111111111111111111111111111111", operators.signedRightShiftPattern(minusOneInBinary, 1));
    }


    @Test
    public void testSignedRightShiftPattern_negativeNumber_minus2(){
        String minusTwoInBinarySigned = "-0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"010";
        assertEquals("11111111111111111111111111111111", operators.signedRightShiftPattern(minusTwoInBinarySigned, 1));
    }

    @Test
    public void testSignedRightShiftPattern_negativeNumber_minus4(){
        String minusFourInBinarySigned = "-0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"100";
        assertEquals("11111111111111111111111111111110", operators.signedRightShiftPattern(minusFourInBinarySigned, 1));
    }

    @Test
    public void testSignedRightShiftPattern_negativeNumber_minus8(){
        String minusEightInBinarySigned = "-0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"0001"+"000";
        assertEquals("11111111111111111111111111111100", operators.signedRightShiftPattern(minusEightInBinarySigned, 1));
    }

    @Test
    public void testSignedRightShiftPattern_positiveNumber_1(){
        String oneInBinary = "0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"001";
        assertEquals("0", operators.signedRightShiftPattern(oneInBinary, 1));
    }


    @Test
    public void testSignedRightShiftPattern_positiveNumber_2(){
        String twoInBinarySigned = "0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"010";
        assertEquals("1", operators.signedRightShiftPattern(twoInBinarySigned, 1));
    }

    @Test
    public void testSignedRightShiftPattern_positiveNumber_4(){
        String fourInBinarySigned = "0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"100";
        assertEquals("10", operators.signedRightShiftPattern(fourInBinarySigned, 1));
    }

    @Test
    public void testSignedRightShiftPattern_positiveNumber_8(){
        String eightInBinarySigned = "0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"0001"+"000";
        assertEquals("100", operators.signedRightShiftPattern(eightInBinarySigned, 1));
    }

    @Test
    public void testSignedRightShiftPattern_allZerosShiftByOne(){
        String allOnes = "0000";
        assertEquals("0", operators.signedRightShiftPattern(allOnes, 1));
    }

    @Test
    public void testlogicalRightShiftPattern_allOnesShiftByOne(){
        String allOnes = "1111";
        assertEquals("111", operators.logicalRightShiftPattern(allOnes, 1));
    }

    @Test
    public void testlogicalRightShiftPattern_LeastSignificantBitIsZeroShiftByOne(){
        String minusOneInBinary = "1111"+"1111"+"1111"+"1111"+"1111"+"1111"+"1111"+"1111";
        assertEquals("1111"+"1111"+"1111"+"1111"+"1111"+"1111"+"1111"+"1111", operators.logicalRightShiftPattern(minusOneInBinary, 1));
    }

    @Test
    public void testlogicalRightShiftPattern_allZerosShiftByOne(){
        String allOnes = "0000";
        assertEquals("0", operators.logicalRightShiftPattern(allOnes, 1));
    }
}