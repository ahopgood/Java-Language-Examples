package com.alexander.java.examples.java7.files;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by alexhopgood on 22/11/16.
 */
public class FileWatcherTest {

    String directoryName = "testDir";
    String fileName = "file1";
    long waitDuration = 1000L;

    @Before
    public void setUp() throws IOException {
        Files.deleteIfExists(Paths.get(directoryName,fileName));
        System.out.println("Does the file exist?" + Files.exists(Paths.get(fileName)));
    }

    @Test(timeout = 10000L)
    public void testWatchOnFileCreation() throws IOException, InterruptedException {
        FileWatcher watcher = new FileWatcher();
        watcher.registerWatcher(directoryName);
        Files.createFile(Paths.get(directoryName, fileName));

        List<WatchEvent<?>> events = watcher.getEvents();
        System.out.println(events.size()+" number of events found");
        assertEquals(StandardWatchEventKinds.ENTRY_CREATE, events.get(0).kind());

        assertEquals(fileName, events.get(0).context().toString());
    }

    @Test(timeout = 10000L)
    public void testWatchOnFileModified() throws IOException, InterruptedException {
        FileWatcher watcher = new FileWatcher();
        watcher.registerWatcher(directoryName);
        Files.createFile(Paths.get(directoryName, fileName));
        Files.newBufferedWriter(Paths.get(directoryName, fileName), StandardCharsets.UTF_8).write("test string");
        //Pop the list of events
        List<WatchEvent<?>> events = watcher.getEvents();

        System.out.println(events.size()+" number of events found");
        assertEquals(StandardWatchEventKinds.ENTRY_MODIFY, events.get(1).kind());
        assertEquals(fileName, events.get(0).context().toString());
    }

    @Test(timeout = 10000L)
    public void testWatchOnDirectoryDeletion() throws IOException, InterruptedException {
        FileWatcher watcher = new FileWatcher();

        Files.createFile(Paths.get(directoryName, fileName));
        watcher.registerWatcher(directoryName);
        Files.deleteIfExists(Paths.get(directoryName, fileName));

        List<WatchEvent<?>> events = watcher.getEvents();

        System.out.println(events.size()+" number of events found");
        assertEquals(StandardWatchEventKinds.ENTRY_DELETE, events.get(0).kind());
        assertEquals(fileName, events.get(0).context().toString());
    }

}