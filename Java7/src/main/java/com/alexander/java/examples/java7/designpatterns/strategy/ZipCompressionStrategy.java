package com.alexander.java.examples.java7.designpatterns.strategy;

import java.io.OutputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by alexhopgood on 26/04/17.
 */
public class ZipCompressionStrategy implements CompressionStrategy {
    @Override
    public OutputStream compress(OutputStream data) {
        return new ZipOutputStream(data);
    }
}
