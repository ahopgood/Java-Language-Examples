package com.alexander.java.examples.java7.files;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alexhopgood on 28/11/16.
 */
public class DirectoryStreamUsageTest {

    private String separator = System.getProperty("file.separator");
    private String sourceFolder = "src"+separator+"main"+separator+"java";
    private String resourceFolder = "src"+separator+"main"+separator+"resources";

    @Test
    public void testPrintJavaFiles() throws IOException {
        DirectoryStreamUsage usage = new DirectoryStreamUsage();
        Path path = Paths.get(sourceFolder, this.getClass().getPackage().getName().split("\\."));

        List<String> javaFiles = usage.printJavaFiles(path);
        assertEquals(5, javaFiles.size());
    }

    @Test
    public void testPrintJavaFiles_givenOnlyTextFiles() throws IOException {
        DirectoryStreamUsage usage = new DirectoryStreamUsage();
        Path path = Paths.get(resourceFolder, this.getClass().getPackage().getName().split("\\."));

        List<String> javaFiles = usage.printJavaFiles(path);
        assertEquals(0, javaFiles.size());
    }

    @Test
    public void testPrintTextFiles() throws IOException {
        DirectoryStreamUsage usage = new DirectoryStreamUsage();
        Path path = Paths.get(resourceFolder, this.getClass().getPackage().getName().split("\\."));

        List<String> textFiles = usage.printTextFiles(path);
        assertEquals(5, textFiles.size());
    }

    @Test
    public void testPrintTextFiles_givenOnlyJavaFiles() throws IOException {
        DirectoryStreamUsage usage = new DirectoryStreamUsage();
        Path path = Paths.get(resourceFolder, this.getClass().getPackage().getName().split("\\."));

        List<String> textFiles = usage.printTextFiles(path);
        assertEquals(5, textFiles.size());
    }
}