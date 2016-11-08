package com.alexander.java.examples.java7;

import org.junit.Test;

/**
 * Created by alexhopgood on 07/11/16.
 */
public class SupressedExceptionsTest {

    @Test
    public void testManagedResourceOpenFile() throws Exception {
        OpenDoorSupressedExceptions mgmt = new OpenDoorSupressedExceptions();
       try ( OpenDoorSupressedExceptions door = new OpenDoorSupressedExceptions() ) {
            door.swing(); /* this throws a SwingExecption */
       } catch (Exception e) {
           System.out.println("Is there a draft? " + e.getClass());
           e.printStackTrace(System.out);
           System.out.println("Supressed warnings ["+e.getSuppressed().length+"]");
           e.getSuppressed()[0].printStackTrace(System.out);
       } finally {
            System.out.println("I'm putting a sweater on, regardless. ");
       }
    }
}