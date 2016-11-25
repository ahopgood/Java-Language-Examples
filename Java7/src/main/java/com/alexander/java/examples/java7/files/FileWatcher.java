package com.alexander.java.examples.java7.files;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchService;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

/**
 * Created by alexhopgood on 22/11/16.
 */
public class FileWatcher {

    WatchService watcher;
    public void registerWatcher(String directoryName) throws IOException {
        watcher = FileSystems.getDefault().newWatchService();
        Paths.get(directoryName).register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
    }

    public List<WatchEvent<?>> getEvents() throws InterruptedException {
        return watcher.take().pollEvents();
    }
}
