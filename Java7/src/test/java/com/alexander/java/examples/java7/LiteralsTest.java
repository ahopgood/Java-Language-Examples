package com.alexander.java.examples.java7;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LiteralsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIntegerBinaryLiteral() {
		assertEquals(Literals.integerValue, Literals.binaryInt);
	}
	
	@Test
	public void testShortBinaryLiteral() {
		assertEquals(Literals.shortValue, Literals.binaryShort);
	}
	
	@Test
	public void testLongBinaryLiteral(){
		assertEquals(Literals.longValue, Literals.longValue);
	}
	
	@Test
	public void testUnderscoreMask(){
		assertEquals(Literals.regularBinaryMask, Literals.underscoreBinaryMask);
	}
	
	@Test
	public void testUnderscordBigNumber(){
		assertEquals(Literals.underscoreBig, Literals.regularBig);
	}
	
	@Test
	public void testUnderscoreCreditCard(){
		assertEquals(Literals.regular_CreditCardNumber, Literals.underscore_CreditCardNumber);
	}
	
	@Test
	public void testUnderscoreHexBytes(){
		assertEquals(Literals.regularHexBytes, Literals.underscoreHexBytes);
	}

	@Test
	public void testUnderscoreWprdBytes(){
		assertEquals(Literals.regularHexBytes, Literals.underscoreHexWords);
	}

}





