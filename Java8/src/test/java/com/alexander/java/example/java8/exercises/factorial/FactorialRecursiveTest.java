package com.alexander.java.example.java8.exercises.factorial;

/**
 * Created by Alexander on 08/07/2017.
 */
public class FactorialRecursiveTest extends FactorialTest {

    @Override
    public Factorial getFactorialImplementation() {
        return new FactorialRecursive();
    }
}