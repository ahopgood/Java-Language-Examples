package com.alexander.java.examples.java7.files;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alexhopgood on 16/12/16.
 */
public class FileSystemUsageTest {

    FileSystemUsage usage = new FileSystemUsage();

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetZipFilesystem() throws Exception {
        String separator = System.getProperty("file.separator");
        String packagePath = this.getClass().getPackage().getName().replace(".", separator);
        String projectPath = "src"+separator+"main"+separator+"resources";
        String uri = "test.zip";

        Path path = Paths.get(projectPath, packagePath, uri);

        System.out.println("zip archive location:");
        System.out.println(path.toAbsolutePath().toString());
        assertTrue(Files.exists(path));
        System.out.println("zip archive file permissions:");
        System.out.println(Files.getPosixFilePermissions(path).toString());

        FileSystem fileSystem = usage.getZipFilesystem(path.toAbsolutePath().toString());

        Path doc = fileSystem.getPath("/doc-a.txt");
        System.out.println(doc.toString());

        Iterator<Path> iter = fileSystem.getRootDirectories().iterator();
        FileTypesVisitor visitor = new FileTypesVisitor();
        while (iter.hasNext()){
            Path rootDir = iter.next();
            Files.walkFileTree(rootDir, visitor);
        }
        assertEquals(1, visitor.getFilesFound().size());
        assertEquals("doc-a.txt", visitor.getFilesFound().get(0).getFileName().toString());
        System.out.println(visitor.getFilesFound().get(0).getFileName().getFileSystem());
    }


    @Test
    public void testAddFile() throws Exception {
        String separator = System.getProperty("file.separator");
        String packagePath = this.getClass().getPackage().getName().replace(".", separator);
        String projectPath = "src"+separator+"main"+separator+"resources";
        String uri = "test.zip";

        Path path = Paths.get(projectPath, packagePath, uri);

        System.out.println(path.toString());
        assertTrue(Files.exists(path));
        System.out.println(Files.getPosixFilePermissions(path).toString());

        FileSystem fileSystem = usage.getZipFilesystem(path.toAbsolutePath().toString());
        fileSystem.getFileStores();

        Path internalFileInZip = fileSystem.getPath("/test/doc-b.txt");
        System.out.println("Internal File "+internalFileInZip.toString());

        Path externalFile = Paths.get(projectPath, packagePath, "doc-b.txt");
        Files.copy(externalFile, internalFileInZip, StandardCopyOption.REPLACE_EXISTING);

        Iterator<Path> iter = fileSystem.getRootDirectories().iterator();
        FileTypesVisitor visitor = new FileTypesVisitor();
        while (iter.hasNext()){
            Path rootDir = iter.next();
            Files.walkFileTree(rootDir, visitor);
        }
        assertFalse(fileSystem.isReadOnly());
        assertEquals(2, visitor.getFilesFound().size());
        assertEquals("doc-b.txt", visitor.getFilesFound().get(0).getFileName().toString());
        System.out.println(visitor.getFilesFound().get(0).getFileName().getFileSystem());
        assertEquals("doc-a.txt", visitor.getFilesFound().get(1).getFileName().toString());
        System.out.println(visitor.getFilesFound().get(1).getFileName().getFileSystem());
        //investigate ZipPath type to understand more about zip file contents
        BufferedReader reader = new BufferedReader(new FileReader(visitor.getFilesFound().get(1).toFile()));
        String line = reader.readLine();
        while (line != null){
            System.out.println(line);
            reader.readLine();
        }
    }

    @Test
    public void testExtractFile() throws Exception {

    }

    /**
     * Visitor used to navigate the root Directory of a zip filesystem
     */
    protected class FileTypesVisitor implements FileVisitor<Path>{

        private List<Path> filesFound = new LinkedList<Path>();
        private List<Path> directoriesFound = new LinkedList<Path>();

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            filesFound.add(file);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        public List<Path> getFilesFound() {
            return filesFound;
        }

        public List<Path> getDirectoriesFound() {
            return directoriesFound;
        }
    }

}