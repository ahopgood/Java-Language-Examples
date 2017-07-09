package com.alexander.java.example.java8.exercises;

import com.alexander.java.example.java8.exercises.factorial.Factorial;
import com.alexander.java.example.java8.exercises.factorial.FactorialRecursive;

/**
 * Created by Alexander on 08/07/2017.
 */
public class FactorialRecursiveTest extends FactorialTest {

    @Override
    public Factorial getFactorialImplementation() {
        return new FactorialRecursive();
    }
}