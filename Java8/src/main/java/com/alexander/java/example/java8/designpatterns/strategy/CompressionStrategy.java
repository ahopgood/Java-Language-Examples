package com.alexander.java.example.java8.designpatterns.strategy;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by alexhopgood on 26/04/17.
 */
public interface CompressionStrategy {
    public OutputStream compress(OutputStream data) throws IOException;
}
