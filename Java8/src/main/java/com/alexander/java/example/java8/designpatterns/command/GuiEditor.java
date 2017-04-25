package com.alexander.java.example.java8.designpatterns.command;

/**
 * Created by Alexander on 25/04/2017.
 */
public class GuiEditor implements Editor {
    @Override
    public void open() {
        System.out.println("Opening...");
    }

    @Override
    public void save() {
        System.out.println("Saving...");
    }

    @Override
    public void close() {
        System.out.println("Closing...");
    }
}
