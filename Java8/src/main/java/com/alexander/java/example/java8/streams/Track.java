package com.alexander.java.example.java8.streams;

/**
 * Created by Alexander on 13/02/2017.
 */
public class Track {
    private String name;
    private int length;

    public String getName() {
        return name;
    }

    public Track setName(String name) {
        this.name = name;
        return this;
    }

    public int getLength() {
        return length;
    }

    public Track setLength(int length) {
        this.length = length;
        return this;
    }
}
