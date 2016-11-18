package com.alexander.java.examples.java7.files;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * <a href="https://docs.oracle.com/javase/tutorial/essential/io/links.html">Oracle io links page</a>
 */
public class FileNavigationHelper {

    /*
     * java.nio.file.Paths <b>class</b> file with static methods for generating
     * paths from various inputs such as URIs.
     */

    /*
     * java.nio.file.Path <b>interface</b> for representing a location of a file
     * on the filesystem, use for doing stuff with files.
     */

    public static File workingDirectory = new File("");
    public static String baseDir = workingDirectory.getAbsolutePath();
    public static Path parentDirectory = Paths.get(baseDir, "src", "main", "java", "com", "alexander", "examples", "java7");

    //Reference to a file
    public static Path getFileReference(){
        System.out.println("Finding file");
        System.out.println(parentDirectory);
        Path src = Paths.get(parentDirectory.toString(), "readme.txt");
        System.out.println(src);
        return src;
    }

    public static Path getDirectoryReference(){
        //Reference to a path
        System.out.println("Finding directory");
        Path directory = Paths.get(parentDirectory.toString());
        System.out.println(directory);
        return directory;
    }

    //Path navigation
    public static Path getChildReference(){
        //resolve a child path
        System.out.println("Finding child");
        System.out.println(parentDirectory);
        Path filesDir = parentDirectory.resolve("files");
        System.out.println(filesDir);
        return filesDir;
    }

    //Path navigation
    public static Path getSiblingReference(){
        //resolve the testdir sibling found in the examples parent dir
        System.out.println("Finding sibling");
        System.out.println(parentDirectory.toString());
        Path testdir = parentDirectory.resolveSibling("testdir");
        System.out.println(testdir);
        return testdir;
    }

    public static Path getRelativeDirectory(){
        //Create a relative path
        System.out.println("Finding testdir relative to parent");
        System.out.println(parentDirectory);
        Path testdir = Paths.get(parentDirectory.toString(), "testdir");
        Path parentRelativeToTestDir = testdir.relativize(parentDirectory);
        System.out.println(parentRelativeToTestDir);
        return parentRelativeToTestDir;
    }

}
