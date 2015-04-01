package com.alexander.java.examples.java7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AutomaticResourceMgmt {
	public InputStream in;
	public OutputStream out;
	
	public void openFile() throws IOException{
		try {
			in = new FileInputStream("test.txt");
			out = new FileOutputStream("desttest.txt");
			
			byte[] buf = new byte[8192];
			int n;
			while ( (n = in.read(buf)) >= 0){
				out.write(buf, 0, n);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null){
				out.close();
			}
			if (in != null){
				in.close();
			}
		}
	}
	
	public InputStream managedIn;
	public OutputStream managedOut;
	
	public void managedResourceOpenFile(){
		try ( 	InputStream in = new FileInputStream("test.txt");
				OutputStream out = new FileOutputStream("desttest.txt")
			){
			managedIn = in;		//only setting this so we can access the streams to verify via tests
			managedOut = out;	//only setting this so we can access the streams to verify via tests
			byte[] buf = new byte[8192];
			int n;
			while ( (n = managedIn.read(buf)) >= 0){
				managedOut.write(buf, 0, n);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
