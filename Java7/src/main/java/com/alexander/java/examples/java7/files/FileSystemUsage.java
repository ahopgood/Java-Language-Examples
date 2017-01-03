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
 * {@link https://docs.oracle.com/javase/7/docs/technotes/guides/io/fsp/zipfilesystemproviderprops.html} provides a list
 * of the environmental properties available for the {@link https://docs.oracle.com/javase/7/docs/technotes/guides/io/fsp/zipfilesystemprovider.html}.
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

        URI u = URI.create("jar:file:"+uri);
        return FileSystems.newFileSystem(u, env);
    }

    public FileSystem addFile(File file, FileSystem fileSystem){
        return fileSystem;
    }

    public File extractFile(String filepath, FileSystem fileSystem){
        return new File("");
    }
}
