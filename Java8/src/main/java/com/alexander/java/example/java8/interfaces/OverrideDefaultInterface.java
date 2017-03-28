package com.alexander.java.example.java8.interfaces;

/**
 * Created by alexhopgood on 21/02/17.
 */
public class OverrideDefaultInterface implements Parent {
    @Override
    public String method(){
        return "This is the concrete method overriding the default interface";
    }

}
