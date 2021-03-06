package com.alexander.java.examples.java7.files;

/**
 * Created by alexhopgood on 09/11/16.
 */

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The java.nio.file.Files class is a class of static methods to operate on files,
 * directories and other types of file.
 *
 * <a href="https://docs.oracle.com/javase/tutorial/essential/io/links.html">Oracle io links page</a>
 */
public class FileHelpers {

    protected String separator = File.separator;
    protected String packagePath = this.getClass().getPackage().getName().toString().replace(".", separator);
    public FileHelpers(){}

    public void copyFile(String source, String target) throws IOException {
        Path sourcePath = Paths.get(source);
        Path targetPath = Paths.get(target);
        Files.copy(sourcePath, targetPath);
    }

    public void createDirectory(String directoryName) throws IOException {
        Path directoryPath = Paths.get(directoryName);
        Files.createDirectories(directoryPath);
    }

    public void createFile(String filename) throws IOException {
        Path path = Paths.get(filename);
        Files.createFile(path);
    }

    public void createHardLink(String filename, String link) throws IOException {
        Path path = Paths.get(filename);
        Path linkPath = Paths.get(link);
        Files.createLink(linkPath, path);
    }

    public void createSymbolicLink(String filename, String link) throws IOException {
        Path path = Paths.get(filename);
        Path linkPath = Paths.get(link);
        Files.createSymbolicLink(linkPath, path);
    }

    public void delete(String filename) throws IOException {
        Path path = Paths.get(filename);
        Files.delete(path);
    }

    public void changeAttributes(String filename) throws IOException {
        Path path = Paths.get(filename);
        Set<PosixFilePermission> permissions = new HashSet<>();
        permissions.add(PosixFilePermission.OTHERS_EXECUTE);
        permissions.add(PosixFilePermission.OTHERS_READ);
        permissions.add(PosixFilePermission.OTHERS_WRITE);
        Files.setPosixFilePermissions(path, permissions);
    }

    public void useTempDirectory(){
//        Files.createTempFile();
    }

    public byte[] readFile(String filename) throws IOException {
        Path path = Paths.get(filename);
        return Files.readAllBytes(path);
    }

    public List<String> readFileLines(String filename) throws IOException {
        Path path = Paths.get(filename);
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }

    public void writeFile(String filename, String text) throws IOException {
        Path path = Paths.get(filename);
        Files.write(path, text.getBytes());
    }

    public void moveFile(String filename, String newFilename) throws IOException {
        Path currentFile = Paths.get(filename);
        Path newFile = Paths.get(newFilename);
        Files.move(currentFile, newFile);
    }
}
