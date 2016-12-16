package com.alexander.java.examples.java7.files;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.*;

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

        System.out.println(path.toString());
        assertTrue(Files.exists(path));
        System.out.println(Files.getPosixFilePermissions(path).toString());

        FileSystem fileSystem = usage.getZipFilesystem(path.toAbsolutePath().toString());
        fileSystem.getFileStores();
        Path doc = fileSystem.getPath("doc-a.txt");
        System.out.println(doc.toString());

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

        Path internalFileInZip = fileSystem.getPath("doc-b.txt");
        System.out.println("Internal File "+internalFileInZip.toString());

        Path externalFile = Paths.get(projectPath, packagePath, "doc-b.txt");
        Files.copy(externalFile, internalFileInZip);

        for (FileStore store: fileSystem.getFileStores()){
            System.out.println(store.name());
            System.out.println(store.type());
        }
    }

    @Test
    public void testExtractFile() throws Exception {

    }
}