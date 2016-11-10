package com.alexander.java.examples.java7.files;

/**
 * Created by alexhopgood on 09/11/16.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The java.nio.file.Files class is a class of static methods to operate on files,
 * directories and other types of file.
 */
public class FileHelpers {

    protected String separator = System.getProperty("file.separator");
    protected String packagePath = this.getClass().getPackage().toString().replace(".", separator);
    public FileHelpers(){}

    public void copyFile(){

    }

    public void createDirectory(){

    }

    public void createFile(String filename) throws IOException {
        Path path = Paths.get(filename);
        Files.createFile(path);
    }

    public void delete(String filename) throws IOException {
        Path path = Paths.get(filename);
        Files.delete(path);
    }

    public void changeAttributes(){

    }

    public void readFile(){

    }

    public void writeFile(){}

    public void moveFile(String filename, String newFilename) throws IOException {
        Path currentFile = Paths.get(filename);
        Path newFile = Paths.get(newFilename);
        Files.move(currentFile, newFile);
    }
}
