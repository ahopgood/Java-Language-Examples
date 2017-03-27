package com.alexander.java.example.java8.interfaces;

/**
 * Created by alexhopgood on 21/02/17.
 */
public interface DefaultInterface {

    default void method(){
        System.out.println("This is the default method");
    }

}
