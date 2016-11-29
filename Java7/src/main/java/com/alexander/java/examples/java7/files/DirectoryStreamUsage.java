package com.alexander.java.examples.java7.files;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * An example of {@link DirectoryStream} usage which implements {@link Iterable} and {@link java.io.Closeable}
 * interfaces for easier and safer management.
 * Scales to large directories.
 * Uses less resources
 * Smooths out response times for remote file systems
 * Built-in support for glob, regex and custom filters.
 * Created by alexhopgood on 28/11/16.
 */
public class DirectoryStreamUsage {
    public DirectoryStreamUsage() {

    }

    public List<String> printJavaFiles(Path directory) throws IOException {
        return printFiles(directory, "*.java");
    }

    public List<String> printTextFiles(Path directory) throws IOException {
        return printFiles(directory, "*.text");
    }

    protected List<String> printFiles(Path directory, String globPattern) throws IOException {
        List<String> list = new LinkedList<>();
        try (DirectoryStream<Path> dir = Files.newDirectoryStream(directory, globPattern)) {
            for (Path javaFile : dir) {
                System.out.println(javaFile.toString());
                list.add(javaFile.toString());
            }
        }
        return list;
    }
}
