package com.alexander.java.example.java8.exercises.factorial;

import static java.lang.Math.abs;

/**
 * Created by Alexander on 08/07/2017.
 */
public class FactorialRecursive implements Factorial {
    
    public long factorial(int factor) {
        if (factor == 0){
            return factor;
        }
        if (factor == 1){
            return 1;
        }
        if (factor < 0){
            return 0;
        } else {
            return factor * factorial(factor -1);   
        }
    }
    //5 * 4 * 3 * 2 * 1
}
