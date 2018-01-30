package com.alexander.java.examples.java7.files;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.*;
/**
 * <a href="https://docs.oracle.com/javase/tutorial/essential/io/notification.html">Oracle IO directory watching page</a>
 * Obtain a {@link WatchService} from the {@link FileSystems} as a static method.
 * Register an implementation of the {@link Watchable} interface, {@link Path} implements this.
 * When registering you can also pass a {@link WatchEvent} to listen for, here are examples of {@link StandardWatchEventKinds}:
 * <ul>
 *     <li>ENTRY_CREATE</li>
 *     <li>ENTRY_DELETE</li>
 *     <li>ENTRY_MODIFY</li>
 *     <li>OVERFLOW - events that might have been lost or discarded</li>
 * </ul>
 */
public class DirectoryWatcher {

    private WatchService watcher;

    public DirectoryWatcher(){
    }

    public List<WatchEvent<?>> getEvents(long waitDuration) throws IOException {
        WatchKey key;
        if (this.watcher != null) {
            try {
                key = watcher.take();
                return key.pollEvents();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public void registerWatcher(String directoryName) throws IOException {
        Path directoryPath = Paths.get(directoryName);
        watcher = FileSystems.getDefault().newWatchService();
        directoryPath.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
    }

    public void unregisterWatcher() throws IOException {
        watcher.close();
    }
}
