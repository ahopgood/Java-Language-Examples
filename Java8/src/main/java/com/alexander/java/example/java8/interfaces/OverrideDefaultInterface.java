package com.alexander.java.example.java8.interfaces;

/**
 * Created by alexhopgood on 21/02/17.
 */
public class OverrideDefaultInterface implements DefaultInterface {
    @Override
    public void method(){
        System.out.println("This is the concrete method overriding the default interface");
    }

}
