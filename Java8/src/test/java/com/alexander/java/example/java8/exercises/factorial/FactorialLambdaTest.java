package com.alexander.java.example.java8.exercises.factorial;

/**
 * Created by Alexander on 09/07/2017.
 */
public class FactorialLambdaTest extends FactorialTest {

    @Override
    public Factorial getFactorialImplementation() {
        return new FactorialLambda();
    }
}