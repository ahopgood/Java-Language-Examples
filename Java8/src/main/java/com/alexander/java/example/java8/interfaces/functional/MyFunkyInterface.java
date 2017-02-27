package com.alexander.java.example.java8.interfaces.functional;

/**
 * A functional interface for testing
 * Created by alexhopgood on 27/02/17.
 */
@FunctionalInterface
public interface MyFunkyInterface<T> {
    public boolean doSomething(T type);
}
