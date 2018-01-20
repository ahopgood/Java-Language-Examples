package com.alexander.java.examples.java7.files;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alexhopgood on 21/11/16.
 */
public class DirectoryWatcherTest {

    String directoryName = "testDir";
    String fileName = "file1";
    long waitDuration = 1000L;

    @Before
    public void setUp() throws IOException {
        Path directoryPath = Paths.get(directoryName);
        Files.createDirectories(directoryPath);
        Files.deleteIfExists(Paths.get(directoryName, fileName));
        System.out.println("Does the file exist?" + Files.exists(Paths.get(directoryName, fileName)));
    }

    @After
    public void destroy(){

    }

    @Test(timeout = 10000L)
    public void testWatchOnDirectoryCreation() throws IOException, InterruptedException {
        DirectoryWatcher watcher = new DirectoryWatcher();
        watcher.registerWatcher(directoryName);
        Files.createFile(Paths.get(directoryName, fileName));

        List<WatchEvent<?>> events = watcher.getEvents(waitDuration);
        System.out.println(events.size()+" number of events found");
        assertEquals(StandardWatchEventKinds.ENTRY_CREATE, events.get(0).kind());
    }

    @Test(timeout = 10000L)
    public void testWatchOnFileAddedDirectory() throws IOException, InterruptedException {
        DirectoryWatcher watcher = new DirectoryWatcher();
        watcher.registerWatcher(directoryName);
        Files.createFile(Paths.get(directoryName, fileName));
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(directoryName, fileName), StandardCharsets.UTF_8);
        writer.write("test string");
        writer.close();
        //Pop the list of events
        List<WatchEvent<?>> events = watcher.getEvents(waitDuration);

        System.out.println(events.size()+" number of events found");
        assertEquals(StandardWatchEventKinds.ENTRY_MODIFY, events.get(1).kind());

    }

    @Test(timeout = 10000L)
    public void testWatchOnDirectoryDeletion() throws IOException, InterruptedException {
        DirectoryWatcher watcher = new DirectoryWatcher();

        watcher.registerWatcher(directoryName);
        Files.createFile(Paths.get(directoryName, fileName));
        Files.deleteIfExists(Paths.get(directoryName, fileName));

        List<WatchEvent<?>> events = watcher.getEvents(waitDuration);

        System.out.println(events.size()+" number of events found");
        assertEquals(StandardWatchEventKinds.ENTRY_DELETE, events.get(1).kind());

    }

}