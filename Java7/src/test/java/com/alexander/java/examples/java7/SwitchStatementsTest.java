package com.alexander.java.examples.java7;

import static org.junit.Assert.*;

import org.junit.Test;

public class SwitchStatementsTest {

	@Test
	public void testSwitchMonth() {
		assertEquals(31, SwitchStatements.stringSwitch(SwitchStatements.jan));
		assertEquals(28, SwitchStatements.stringSwitch(SwitchStatements.feb));
		assertEquals(31, SwitchStatements.stringSwitch(SwitchStatements.march));
		assertEquals(30, SwitchStatements.stringSwitch(SwitchStatements.april));
		assertEquals(31, SwitchStatements.stringSwitch(SwitchStatements.may));
		assertEquals(30, SwitchStatements.stringSwitch(SwitchStatements.june));
		assertEquals(31, SwitchStatements.stringSwitch(SwitchStatements.july));
		assertEquals(31, SwitchStatements.stringSwitch(SwitchStatements.aug));
		assertEquals(30, SwitchStatements.stringSwitch(SwitchStatements.sept));
		assertEquals(31, SwitchStatements.stringSwitch(SwitchStatements.oct));
		assertEquals(30, SwitchStatements.stringSwitch(SwitchStatements.nov));
		assertEquals(31, SwitchStatements.stringSwitch(SwitchStatements.dec));
	}
	
}
