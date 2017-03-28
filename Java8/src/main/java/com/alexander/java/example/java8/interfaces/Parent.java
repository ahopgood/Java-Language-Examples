package com.alexander.java.example.java8.interfaces;

/**
 * Created by alexhopgood on 21/02/17.
 */
public interface Parent {

    default String method(){
        return "Welcome from Parent default interface";
    }

}
