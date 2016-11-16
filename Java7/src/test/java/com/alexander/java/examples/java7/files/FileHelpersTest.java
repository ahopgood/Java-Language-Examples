package com.alexander.java.examples.java7.files;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.ParallelComputer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

import static org.junit.Assert.assertEquals;
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
    public void testCopyFile() throws IOException {
        String filename = "testfile.txt";
        File output = new File(filename);
        //Write come content to verify the file copy operation
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(output)) ){
            writer.write("This is a test file");
            writer.close();
        }

        String copied = "copiedfile.txt";
        File copiedFile = new File(copied);
        try {
            helper.copyFile(filename, copied);
            assertTrue(copiedFile.exists());
            assertTrue(copiedFile.isFile());
            assertEquals(true, output.length() > 0);
            assertEquals(output.length(), copiedFile.length());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output.exists()) {
                output.delete();
            }
            if (copiedFile.exists()){
                copiedFile.delete();
            }
        }
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
