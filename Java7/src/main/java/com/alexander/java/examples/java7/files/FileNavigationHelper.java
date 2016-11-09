package com.alexander.java.examples.java7.files;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by alexhopgood on 09/11/16.
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

    public FileNavigationHelper(){
        File workingDirectory = new File("");
        String baseDir = workingDirectory.getAbsolutePath();

        //Reference to a file
        Path src = Paths.get(baseDir, "src", "main", "java", "readme.txt");

        //Reference to a path
        Path directory = Paths.get(baseDir, "src", "main", "java");

        Path parentDirectory = Paths.get(baseDir, "src", "main", "java", "com", "alexander", "examples", "java7");

        //Path navigation
        //resolve a child path
        Path filesDir = parentDirectory.resolve("files");
        System.out.println(filesDir);

        //resolve the testdir sibling found in the examples parent dir
        Path testdir = parentDirectory.resolveSibling("testdir");
        System.out.println(testdir.toAbsolutePath());

        //Create a relative path
        Path parentRelativeToTestDir = testdir.relativize(parentDirectory);
        System.out.println(parentRelativeToTestDir.toString());
    }
}
