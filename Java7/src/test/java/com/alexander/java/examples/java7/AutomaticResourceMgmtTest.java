package com.alexander.java.examples.java7;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class AutomaticResourceMgmtTest {

	@Test
	public void testOpenFile() throws IOException {
		AutomaticResourceMgmt mgmt = new AutomaticResourceMgmt();
		assertNull(mgmt.in);
		assertNull(mgmt.out);
		mgmt.openFile();
		assertNotNull(mgmt.in);
		assertNotNull(mgmt.out);
		
		try {
			mgmt.out.write(1);
			fail("FileOutputStream should be closed, instead we have been able to write to it.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			assertEquals(-1, mgmt.in.read()); //attempt to read, if properly closed should throw an IOException
			fail("FileInputStream should be closed, instead we have been able to write to it.");
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testManagedResourceOpenFile(){
		AutomaticResourceMgmt mgmt = new AutomaticResourceMgmt();
		assertNull(mgmt.managedIn);
		assertNull(mgmt.managedOut);
		mgmt.managedResourceOpenFile();
		assertNotNull(mgmt.managedIn);
		assertNotNull(mgmt.managedOut);
		
		try {
			assertEquals(-1, mgmt.managedIn.read()); //attempt to read, if properly closed should throw an IOException
			fail("FileInputStream should be closed, instead we have been able to write to it.");
		} catch (IOException e){
			e.printStackTrace();
		}
		
		try {
			mgmt.managedOut.write(1);
			fail("FileOutputStream should be closed, instead we have been able to write to it.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
