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

        return "";
    }

    public static int createFromBinary(String binary){
        return Integer.parseInt(binary, 2);
    }

    public String cropToInputMagnitude(String input, String valueToCrop){
        return valueToCrop.substring(valueToCrop.length()-input.length(), valueToCrop.length());
    }
}
