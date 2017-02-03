package com.alexander.java.example.java6;

/**
 * Created by alexhopgood on 30/01/17.
 */
public class BitwiseOperators {

    public static void main(String[] args){
        BitwiseOperators bit = new BitwiseOperators();
    }

    public String invertBitPattern(String binaryString){
        int binaryValue = createFromBinary(binaryString);
        System.out.println(binaryString);
        int inverseBinary = ~binaryValue;
        return Integer.toBinaryString(inverseBinary);
    }

    public String xorBitPatterns(String value1, String value2){
        int binaryValue1 = createFromBinary(value1);
        int binaryValue2 = createFromBinary(value2);
        int xordValue = binaryValue1^binaryValue2;
        return Integer.toBinaryString(xordValue);
    }

    public String andBitPattern(String value1, String value2){
        int binaryValue1 = createFromBinary(value1);
        System.out.println(binaryValue1);
        int binaryValue2 = createFromBinary(value2);
        System.out.println(binaryValue2);
        int andValue = binaryValue1&binaryValue2;
        System.out.println(andValue);
        return Integer.toBinaryString(andValue);
    }

    public String orBitPattern(String value1, String value2){
        int binaryValue1 = createFromBinary(value1);
        System.out.println(binaryValue1);
        int binaryValue2 = createFromBinary(value2);
        System.out.println(binaryValue2);
        int orValue = binaryValue1|binaryValue2;
        System.out.println(orValue);
        return Integer.toBinaryString(orValue);
    }

    public String signedLeftShiftPattern(String value1, int shift){
        System.out.println(value1);
        int binaryValue1 = createFromBinary(value1);
        System.out.println(binaryValue1);
        int shiftedValue = binaryValue1<<shift;
        return Integer.toBinaryString(shiftedValue);
    }

    public String signedRightShiftPattern(String value1, int shift){
        System.out.println(value1);
        int binaryValue1 = createFromBinary(value1);
        System.out.println(binaryValue1);
        int shiftedValue = binaryValue1>>shift;
        return Integer.toBinaryString(shiftedValue);
    }

    public String signedRightShiftPaddingPattern(String value1, int shift){
        System.out.println(value1);
        int binaryValue1 = createFromBinary(value1);
        System.out.println(binaryValue1);
        int shiftedValue = binaryValue1>>>shift;
        return Integer.toBinaryString(shiftedValue);
    }

//    public String

    public static int createFromBinary(String binary){
        return Integer.parseInt(binary, 2);
    }

    public String cropToInputMagnitude(String input, String valueToCrop){
        return valueToCrop.substring(valueToCrop.length()-input.length(), valueToCrop.length());
    }
}
