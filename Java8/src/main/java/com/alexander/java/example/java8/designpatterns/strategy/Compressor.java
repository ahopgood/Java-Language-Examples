package com.alexander.java.example.java8.designpatterns.strategy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by alexhopgood on 26/04/17.
 */
public class Compressor {
    private final CompressionStrategy strategy;


    public Compressor(CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    public void compress(Path inFile, File outFile) throws IOException {
        try (OutputStream outStream = new FileOutputStream(outFile)){
            Files.copy(inFile, strategy.compress(outStream));
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println();
//        Compressor.class.getPackage().toString().split(",")
        Path inFile = Paths.get("Java8", "src", "main", "java", "com", "alexander", "java", "example", "java8", "designpatterns", "strategy", "test.txt");
//        Path inFile = Paths.get("Java7", "src", "main", "java", Compressor.class.getPackage().toString().split(","), "test.txt");
        System.out.println(inFile.toFile().exists());
        System.out.println(inFile.toAbsolutePath().toString());

        File gzipOut = Paths.get("Java8", "src", "main", "java", "com", "alexander", "java", "example", "java8", "designpatterns", "strategy", "test.gz").toFile();
        File zipOut = Paths.get("Java8", "src", "main", "java", "com", "alexander", "java", "example", "java8", "designpatterns", "strategy", "test.zip").toFile();

        Compressor gzipCompressor = new Compressor(GZIPOutputStream::new);
        gzipCompressor.compress(inFile, gzipOut);

        Compressor zipCompressor = new Compressor(ZipOutputStream::new);
        zipCompressor.compress(inFile, zipOut);

    }
}
