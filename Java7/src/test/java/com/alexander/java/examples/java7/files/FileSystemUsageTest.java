package com.alexander.java.examples.java7.files;

import org.junit.*;

import java.io.*;
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

    static String separator = System.getProperty("file.separator");
    static FileSystemUsage usage = new FileSystemUsage();
    static String packagePath = FileSystemUsageTest.class.getPackage().getName().replace(".", separator);
    static String projectPath = "src"+separator+"main"+separator+"resources";
    static String uri = "test.zip";
    static FileSystem fileSystem;

    @BeforeClass
    public static void setUpBefore() throws Exception {
        Path zipPath = Paths.get(projectPath, packagePath, uri);
        System.out.println("zip archive location:");
        System.out.println(zipPath.toString());

        assertTrue(Files.exists(zipPath));
        try {
            System.out.println("zip archive file permissions:");
            System.out.println(Files.getPosixFilePermissions(zipPath).toString());
        } catch (UnsupportedOperationException uoe){
            System.out.println("OS does not support reading of attributes");
        }
        System.out.println(zipPath.toUri().toString());
        if (fileSystem == null || !fileSystem.isOpen()) {
            fileSystem = usage.getZipFilesystem(zipPath.toUri().toString());
        }
    }

    @AfterClass
    public static void tearDownAfter() throws IOException {
//        fileSystem.close();
    }

    @Test
    public void testGetZipFilesystem() throws Exception {
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
//        fileSystem.close();
        //Not closing the file system as that'll actually save the file and then we cannot re-add it.

    }


    @Test
    public void testAddFile() throws Exception {
        usage.addFile(Paths.get(projectPath, packagePath, "doc-b.txt").toFile(), fileSystem);
//        System.out.println("Is open?:"+fileSystem.isOpen());
        assertTrue(fileSystem.isOpen());
//        System.out.println("Is readonly?:"+fileSystem.isReadOnly());
        assertFalse(fileSystem.isReadOnly());

        Iterator<Path> iter = fileSystem.getRootDirectories().iterator();
        FileTypesVisitor visitor = new FileTypesVisitor();
        while (iter.hasNext()){
            Path rootDir = iter.next();
            Files.walkFileTree(rootDir, visitor);
        }
        assertEquals(2, visitor.getFilesFound().size());
        assertEquals("doc-b.txt", visitor.getFilesFound().get(0).getFileName().toString());
        System.out.println(visitor.getFilesFound().get(0).getFileName().getFileSystem());
        assertEquals("doc-a.txt", visitor.getFilesFound().get(1).getFileName().toString());
        System.out.println(visitor.getFilesFound().get(1).getFileName().getFileSystem());
//        fileSystem.close();
        //Not closing the file system as that'll actually save the file and then we cannot re-add it.
        Files.delete(fileSystem.getPath("doc-b.txt"));
    }

    @Test
    public void testExtractFile() throws Exception {
        File file = null;
        try {
            file = usage.extractFile("/doc-a.txt", fileSystem);
            assertTrue(file.exists());
            System.out.println(file.getAbsolutePath());
        } finally {
            if (file != null && file.exists()) {
                file.delete();
            }
        }
    }

    @Test
    public void testRemoveFile() throws Exception {
        usage.removeFile("/doc-a.txt", fileSystem);
//        System.out.println("Is open?:"+fileSystem.isOpen());
        assertTrue(fileSystem.isOpen());
//        System.out.println("Is readonly?:"+fileSystem.isReadOnly());
        assertFalse(fileSystem.isReadOnly());

        Iterator<Path> iter = fileSystem.getRootDirectories().iterator();
        FileTypesVisitor visitor = new FileTypesVisitor();
        while (iter.hasNext()){
            Path rootDir = iter.next();
            Files.walkFileTree(rootDir, visitor);
        }
        assertEquals(0, visitor.getFilesFound().size());

//        fileSystem.close();
        //Not closing the file system as that'll actually save the file and then we cannot re-add it.
        Files.copy(Paths.get(projectPath, packagePath, "doc-a.txt"), fileSystem.getPath("doc-a.txt"));
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