package com.alexander.java.example.java8.exercises;

import com.alexander.java.example.java8.exercises.factorial.Factorial;
import com.alexander.java.example.java8.exercises.factorial.FactorialLambda;

/**
 * Created by Alexander on 09/07/2017.
 */
public class FactorialLambdaTest extends FactorialTest {

    @Override
    public Factorial getFactorialImplementation() {
        return new FactorialLambda();
    }
}