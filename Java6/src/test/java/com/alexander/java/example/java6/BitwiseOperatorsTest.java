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

    //Signed Right Shift >>
    @Test
    public void testSignedRightShiftPattern_negativeNumber_minus2_thenReturn_minus_1(){
        String minusTwoInBinarySigned = "-0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"010";
        assertEquals("11111111111111111111111111111111", operators.signedRightShiftPattern(minusTwoInBinarySigned, 1));
        //11111111111111111111111111111110  //original value
        //11111111111111111111111111111111  //shifted right by one with sign extension
    }

    @Test
    public void testSignedRightShiftPattern_negativeNumber_minus4_thenReturn_minus_2(){
        String minusFourInBinarySigned = "-0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"100";
        assertEquals("11111111111111111111111111111110", operators.signedRightShiftPattern(minusFourInBinarySigned, 1));
        //11111111111111111111111111111101  //original binary number
        //11111111111111111111111111111110   //shifted right by one with sign extension
    }

    @Test
    public void testSignedRightShiftPattern_negativeNumber_minus8_thenReturn_minus_4(){
        String minusEightInBinarySigned = "-0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"0001"+"000";
        assertEquals("11111111111111111111111111111100", operators.signedRightShiftPattern(minusEightInBinarySigned, 1));
        //11111111111111111111111111111000  //original binary number
        //11111111111111111111111111111100   //shifted right by one
    }

    @Test
    public void testSignedRightShiftPattern_positiveNumber_1_thenReturn_zero(){
        String oneInBinary = "0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"001";
        assertEquals("0", operators.signedRightShiftPattern(oneInBinary, 1));
        //00000000000000000000000000000001  //original binary number
        //00000000000000000000000000000000   //shifted right by one
    }

    @Test
    public void testSignedRightShiftPattern_positiveNumber_2_thenReturn_1(){
        String twoInBinarySigned = "0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"010";
        assertEquals("1", operators.signedRightShiftPattern(twoInBinarySigned, 1));
        //00000000000000000000000000000010  //original binary number
        //00000000000000000000000000000001   //shifted right by one

    }

    @Test
    public void testSignedRightShiftPattern_positiveNumber_4_thenReturn_2(){
        String fourInBinarySigned = "0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"100";
        assertEquals("10", operators.signedRightShiftPattern(fourInBinarySigned, 1));
        //00000000000000000000000000000100  //original binary number
        //00000000000000000000000000000010   //shifted right by one
    }

    @Test
    public void testSignedRightShiftPattern_positiveNumber_8_thenReturn_4(){
        String eightInBinarySigned = "0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"0001"+"000";
        assertEquals("100", operators.signedRightShiftPattern(eightInBinarySigned, 1));
        //00000000000000000000000000001000  //original binary number
        //00000000000000000000000000000100   //shifted right by one
    }

    @Test
    public void testSignedRightShiftPattern_allZerosShiftByOne(){
        String allOnes = "0000";
        assertEquals("0", operators.signedRightShiftPattern(allOnes, 1));
    }

    //Logical Right Shift >>>
    @Test
    public void testlogicalRightShiftPattern_negativeNumber_minus2_thenReturn_2147483647(){
        String minusTwoInBinarySigned = "-0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"010";
        assertEquals("1111111111111111111111111111111", operators.logicalRightShiftPattern(minusTwoInBinarySigned, 1));
        //11111111111111111111111111111110  //original binary number
        //(0)1111111111111111111111111111111   //shifted right by one
    }

    @Test
    public void testLogicalRightShiftPattern_negativeNumber_minus4_thenReturn_2147483646(){
        String minusFourInBinarySigned = "-0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"100";
        assertEquals("1111111111111111111111111111110", operators.logicalRightShiftPattern(minusFourInBinarySigned, 1));
        //11111111111111111111111111111100  //original binary number
        //(0)1111111111111111111111111111110   //shifted right by one
    }

    @Test
    public void testLogicalRightShiftPattern_negativeNumber_minus8_thenReturn_2147483644(){
        String minusEightInBinarySigned = "-0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"0001"+"000";
        assertEquals("1111111111111111111111111111100", operators.logicalRightShiftPattern(minusEightInBinarySigned, 1));
        //11111111111111111111111111111000  //original binary number
        //(0)1111111111111111111111111111100   //shifted right by one
    }

    @Test
    public void testLogicalRightShiftPattern_positiveNumber_1_thenReturn_zero(){
        String oneInBinary = "0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"001";
        assertEquals("0", operators.logicalRightShiftPattern(oneInBinary, 1));
        //00000000000000000000000000000001  //original binary number
        //(0)0000000000000000000000000000000   //shifted right by one
    }

    @Test
    public void testLogicalRightShiftPattern_positiveNumber_2_thenReturn_1(){
        String twoInBinarySigned = "0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"010";
        assertEquals("1", operators.logicalRightShiftPattern(twoInBinarySigned, 1));
        //00000000000000000000000000000010  //original binary number
        //(0)0000000000000000000000000000001   //shifted right by one
    }

    @Test
    public void testLogicalRightShiftPattern_positiveNumber_4_thenReturn_2(){
        String fourInBinarySigned = "0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"100";
        assertEquals("10", operators.logicalRightShiftPattern(fourInBinarySigned, 1));
        //00000000000000000000000000000100  //original binary number
        //(0)0000000000000000000000000000010   //shifted right by one

    }

    @Test
    public void testLogicalRightShiftPattern_positiveNumber_8_thenReturn_4(){
        String eightInBinarySigned = "0000"+"0000"+"0000"+"0000"+"0000"+"0000"+"0001"+"000";
        assertEquals("100", operators.logicalRightShiftPattern(eightInBinarySigned, 1));
        //00000000000000000000000000001000  //original binary number
        //(0)0000000000000000000000000000100   //shifted right by one
    }

}