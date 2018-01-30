package com.alexander.java.examples.java7.files;

import java.io.IOException;
import java.nio.file.*;
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

    public List<WatchEvent<?>> getEvents(long waitDuration) throws InterruptedException {
        WatchKey key;
        if (this.watcher != null) {
            try {
                key = watcher.take();
                Thread.sleep(waitDuration);
                return key.pollEvents();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
