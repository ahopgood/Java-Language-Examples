package com.alexander.java.examples.java7.files;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alexhopgood on 30/11/16.
 */
public class FileVisitorUsageTest {

    private String separator = System.getProperty("file.separator");
    private String sourceFolder = "src"+separator+"main"+separator+"java";
    private String resourceFolder = "src"+separator+"main"+separator+"resources";
    private String[] packageFolder = this.getClass().getPackage().getName().split("\\.");

    @Test
    public void testPreVisitDirectory() throws Exception {
        Path path = Paths.get(sourceFolder, packageFolder);
        FileVisitorUsage visitor = new FileVisitorUsage();
        visitor.preVisitDirectory(path, null);
        assertEquals("Entering directory Name :"+path.toString(), visitor.getVisited().get(0));
    }

    @Test
    public void testVisitFile_givenDirectory() throws Exception {
        Path path = Paths.get(sourceFolder, packageFolder);
        FileVisitorUsage visitor = new FileVisitorUsage();
        visitor.visitFile(path, null);
        assertEquals("Visiting file name :" + path.toString(), visitor.getVisited().get(0));
    }

    @Test
    public void testVisitFile_givenFile() throws Exception {
        String[] location = Arrays.copyOf(packageFolder, packageFolder.length+1);
        location[packageFolder.length] = "FileVisitorUsage.java";
        Path path = Paths.get(sourceFolder, location);
        System.out.println("File:"+path.toString());

        FileVisitorUsage visitor = new FileVisitorUsage();
        visitor.visitFile(path, null);
        assertEquals("Visiting file name :" + path.toString(), visitor.getVisited().get(0));
    }

    @Test
    public void testVisitFileFailed() throws Exception {
        Path path = Paths.get(sourceFolder, packageFolder);
        FileVisitorUsage visitor = new FileVisitorUsage();
        visitor.visitFileFailed(path, new IOException("Test exception"));

        assertEquals("Test exception",  visitor.getVisited().get(0));
    }

    @Test
    public void testPostVisitDirectory() throws Exception {
        Path path = Paths.get(sourceFolder, packageFolder);
        FileVisitorUsage visitor = new FileVisitorUsage();
        visitor.postVisitDirectory(path, null);
        assertEquals("Leaving directory Name :" + path.toString(), visitor.getVisited().get(0));
    }

    @Test
    public void testWalkFileTree() throws IOException {
        Path path = Paths.get(sourceFolder, packageFolder);
        FileVisitorUsage visitor = new FileVisitorUsage();
        Files.walkFileTree(path, visitor);
        assertEquals("Entering directory Name :" + path.toString(), visitor.getVisited().get(0));
        assertEquals("Leaving directory Name :"+path.toString(), visitor.getVisited().get(8));
    }
}