package com.alexander.java.examples.java7;

import java.io.*;

/**
 * An exception can be thrown from the block of code associated with the try-with-resources statement.
 * In the example writeToFileZipFileContents, an exception can be thrown from the try block, and up to two exceptions can be thrown from the try-with-resources statement when it tries to close the ZipFile and BufferedWriter objects.
 * If an exception is thrown from the try block and one or more exceptions are thrown from the try-with-resources statement, then those exceptions thrown from the try-with-resources statement are suppressed, and the exception thrown by the block is the one that is thrown by the writeToFileZipFileContents method.
 * You can retrieve these suppressed exceptions by calling the Throwable.getSuppressed method from the exception thrown by the try block.
 *
 * AutoCloseable is the interface that automated resource management uses to ensure that close() methods are called.
 * Created by alexhopgood on 07/11/16.
 */
public class OpenDoorSupressedExceptions implements AutoCloseable {

    class OpenException extends Exception {}
    class SwingException extends Exception {}
    class CloseException extends Exception {}

    public OpenDoorSupressedExceptions() throws Exception {
        System.out.println("The door is open");
    }

    public void swing() throws Exception {
        System.out.println("The door is becoming unhinged.");
        throw new SwingException();
    }

    @Override
    public void close() throws Exception {
        System.out.println("The door is closed");
        throw new CloseException(); /* throwing CloseException */
    }
}
