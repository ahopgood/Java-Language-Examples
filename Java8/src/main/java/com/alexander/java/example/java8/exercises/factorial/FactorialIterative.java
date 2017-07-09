package com.alexander.java.example.java8.exercises.factorial;

public class FactorialIterative implements Factorial {

    public long factorial(int factor) {
        if (factor < 0){
            return 0;
        }
        long aggregator = factor;
        for (int i = factor-1; i > 0; i--){
            aggregator *= i;
        }
        return aggregator;
    }
}
