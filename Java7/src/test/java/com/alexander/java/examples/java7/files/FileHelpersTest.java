package com.alexander.java.examples.java7.files;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.ParallelComputer;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by Alexander on 10/11/2016.
 */
public class FileHelpersTest {

    private FileHelpers helper;

    @Before
    public void setUp(){
        helper = new FileHelpers();
    }

    @Test
    public void testCreateFile(){
        String filename = "testfile.txt";
        File output = new File(filename);
        try {
            helper.createFile(filename);
            assertTrue(output.exists());
            assertTrue(output.isFile());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output.exists()) {
                output.delete();
            }
        }
    }

    @Test
    public void testDeleteFile(){
        String filename = "testfile.txt";
        File output = new File(filename);
        try {
            output.createNewFile();
            assertTrue(output.exists());
            assertTrue(output.isFile());
            helper.delete(filename);
            assertTrue(!output.exists());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output.exists()) {
                output.delete();
            }
        }
    }


    @Test
    public void testMoveFile(){
        String filename = "testfile.txt";
        String movedFile = "movedfile.txt";
        File output = new File(filename);
        File newFile = new File(movedFile);
        try {
            output.createNewFile();
            assertTrue(output.exists());
            assertTrue(output.isFile());
            helper.moveFile(filename, movedFile);
            assertTrue(newFile.exists());
            assertTrue(newFile.isFile());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output.exists()) {
                output.delete();
                fail("Old file still exists ["+filename+"]");
            }
            if (newFile.exists()) {
                newFile.delete();
            }
        }
    }
}
