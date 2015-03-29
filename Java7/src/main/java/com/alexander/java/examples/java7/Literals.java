package com.alexander.java.examples.java7;

public class Literals {

	/* Can now define binary literals in the same way we can do hex values */
	static int binaryInt = 0b1111;
	static int integerValue = 15;
	static short binaryShort = 0b1111;
	static short shortValue = 15;
	static long binaryLong = 0b1111;
	static long longValue = 15;
	
	int[] happyFace = {
			(short)0b000111111000,
			(short)0b001000000100,
			(short)0b010000000010,
			(short)0b100110011001,
			(short)0b100000000001,
			(short)0b100100001001,
			(short)0b100011110001,
			(short)0b010000000010,
			(short)0b001111111100
	};
	
	/* Underscores in literals */
	static int underscoreBinaryMask = 0b1010_1010_1010;
	static int regularBinaryMask = 0b101010101010;
	static long underscoreBig = 9_223_783_036_967_937L;
	static long regularBig = 9223783036967937L;
	static long underscore_CreditCardNumber = 1234_5678_9101_1121L;
	static long regular_CreditCardNumber = 1234567891011121L;
	
	static long underscoreHexBytes = 0xFF_CE_DE_5E;
	static long regularHexBytes = 0xFFCEDE5E;
	static long underscoreHexWords = 0xFFCE_DE5E;
	
	
	
	
}




