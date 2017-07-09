package com.alexander.java.example.java8.exercises;

import com.alexander.java.example.java8.exercises.factorial.Factorial;
import com.alexander.java.example.java8.exercises.factorial.FactorialIterative;

/**
 * Created by Alexander on 08/07/2017.
 */
public class FactorialIterativeTest extends FactorialTest {

    @Override
    public Factorial getFactorialImplementation() {
        return new FactorialIterative();
    }
}