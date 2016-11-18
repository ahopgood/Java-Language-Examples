package com.alexander.java.examples.java7.files;

import java.io.IOException;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

/**
 * <a href="https://docs.oracle.com/javase/tutorial/essential/io/links.html">Oracle io links page</a>
 */
public class DirectoryWatcher implements WatchService {

    public static void main(String[] args){

    }


    @Override
    public void close() throws IOException {

    }

    @Override
    public WatchKey poll() {
        return null;
    }

    @Override
    public WatchKey poll(long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public WatchKey take() throws InterruptedException {
        return null;
    }
}
