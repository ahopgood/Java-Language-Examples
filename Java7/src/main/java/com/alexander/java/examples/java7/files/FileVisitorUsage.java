package com.alexander.java.examples.java7.files;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of the {@link FileVisitor} interface.
 * More information on how to use this can be found in the Oracle docs {@link https://docs.oracle.com/javase/tutorial/essential/io/walk.html}
 * If you just want to extend the {@link SimpleFileVisitor} an example then that can be done too.
 * Created by alexhopgood on 30/11/16.
 */
public class FileVisitorUsage implements FileVisitor<Path>{

    private List<String> visited = new LinkedList<String>();

    public List<String> getVisited(){
        return this.visited;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        String currentString = "Entering directory Name :" + dir.toString();
        this.visited.add(currentString);
        System.out.println(currentString);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String currentString = "Visiting file name :" + file.toString();

        this.visited.add(currentString);
        System.out.println(currentString);
        if (attrs != null) {
            System.out.println("Attribute - Is regular file?:" + attrs.isRegularFile());
            System.out.println("Attribute - Last Modified Time:" + attrs.lastModifiedTime());
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        this.visited.add(exc.getLocalizedMessage());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        String currentString  = "Leaving directory Name :"+ dir.toString();
        this.visited.add(currentString);
        System.out.println(currentString);
        return FileVisitResult.CONTINUE;
    }
}
