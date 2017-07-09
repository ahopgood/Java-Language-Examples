package com.alexander.java.example.java8.exercises.factorial;

import java.util.stream.LongStream;

/**
 * Created by Alexander on 09/07/2017.
 */
public class FactorialLambda implements Factorial {

    public long factorial(int factor) {
        if (factor <= 0) return 0;
        return LongStream.rangeClosed(1,factor)
                .reduce(1, (a,b) -> a * b);
    }
}
