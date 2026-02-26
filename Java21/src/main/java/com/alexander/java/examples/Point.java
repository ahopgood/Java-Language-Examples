package com.alexander.java.examples;

/**
 * Record that contains co-ordinates in a 2D space
 * @param x
 * @param y
 */
public record Point(int x, int y) {

    public Point(int x) {
        this(x, 0);
    }
}