package com.alexander.java.examples.java7.designpatterns.strategy;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by alexhopgood on 26/04/17.
 */
public interface CompressionStrategy {
    public OutputStream compress(OutputStream data) throws IOException;
}
