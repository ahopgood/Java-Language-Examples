package com.alexander.java.example.java8.interfaces.functional;

/**
 * Created by alexhopgood on 06/03/17.
 */
public class Overloader {

    public void overloadedMethod(MyFunkyInterface<Integer> lambda){
        System.out.println("MyFunkyInterface");
    }

    public void overloadedMethod(MyFunkyIntegerInterface lambda){
        System.out.println("MyFunkyIntegerInterface");
    }

}
