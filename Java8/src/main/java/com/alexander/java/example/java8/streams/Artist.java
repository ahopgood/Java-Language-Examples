package com.alexander.java.example.java8.streams;

/**
 * Created by alexhopgood on 13/02/17.
 */
public class Artist {
    private String name;
    private String from;

    public String getFrom() {
        return from;
    }

    public Artist setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getName() {
        return name;
    }

    public Artist setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isFrom(String location){
        return from.equalsIgnoreCase(location);
    }
}
