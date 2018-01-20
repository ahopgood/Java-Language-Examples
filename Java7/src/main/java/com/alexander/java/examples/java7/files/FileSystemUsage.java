package com.alexander.java.examples.java7.files;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URI;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.spi.FileSystemProvider;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * {@link java.nio.file.FileSystems} is a factory for the {@link FileSystem} (interface)
 * One can create a custom filesystem by implementing {@link java.nio.file.spi.FileSystemProvider} for URI, caching and file
 * handling and by implementing {@link FileSystem} for Roots, Read-Write and file store.
 * <a href="https://docs.oracle.com/javase/7/docs/technotes/guides/io/fsp/zipfilesystemproviderprops.html">Zip Filesystem Provider Properties</a> provides a list
 * of the environmental properties available for the <a href="https://docs.oracle.com/javase/7/docs/technotes/guides/io/fsp/zipfilesystemprovider.html">Zip Filesystem Provider</a></a>.
 * Created by alexhopgood on 05/12/16.
 */
public class FileSystemUsage {

    FileSystemUsage (){
        Map<String, String> env = new HashMap<>();
        env.put("create","true");
    }

    public FileSystem getZipFilesystem(String uri) throws IOException {
        Map<String, String> env = new HashMap<>();
        env.put("create","true");

        URI u = URI.create("jar:"+uri);
        return FileSystems.newFileSystem(u, env);
    }

    public FileSystem addFile(File file, FileSystem fileSystem) throws IOException {
        Path sourcePath = Paths.get(file.toURI());
        Path destinationPath = fileSystem.getPath(file.getName());
//        Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        Files.copy(sourcePath, destinationPath);
        return fileSystem;
    }

    public File extractFile(String filepath, FileSystem fileSystem) throws IOException {
        Path sourcepath = fileSystem.getPath(filepath);
        Path destinationPath = Paths.get(sourcepath.getFileName().toString());
        Files.copy(sourcepath, destinationPath);
        return destinationPath.toFile();
    }

    public FileSystem removeFile(String filepath, FileSystem fileSystem) throws IOException {
        Path path = fileSystem.getPath(filepath);
        Files.delete(path);
        return fileSystem;
    }
}
