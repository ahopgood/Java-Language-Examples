package com.alexander.java.examples.java7.files;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alexhopgood on 09/11/16.
 */
public class FileNavigationHelperTest {


    String separator = System.getProperty("file.separator");
    String parent = FileNavigationHelper.parentDirectory.toString();

    @Test
    public void testFileReference(){
        assertEquals(parent+separator+"readme.txt",
                FileNavigationHelper.getFileReference().toString());
    }
    @Test public void testDirectoryReference(){
        assertEquals(parent,
                FileNavigationHelper.getDirectoryReference().toString());
    }
    @Test public void childReference(){
        assertEquals(parent+separator+"files",
                FileNavigationHelper.getChildReference().toString());
    }
    @Test public void testSiblingReference(){
        assertEquals(parent.replace("java7","testdir"),
                FileNavigationHelper.getSiblingReference().toString());
    }
    @Test public void testRelativeDirectory(){
        assertEquals("..", //as the test directory is one up in the dir structure
                FileNavigationHelper.getRelativeDirectory().toString());
    }

}