package com.alexander.java.example.java8.interfaces.functional;

import java.util.LinkedList;

/**
 * An example of using a functional interface on a LinkedList
 * Created by alexhopgood on 27/02/17.
 */
public class MyFunkyList<T> extends LinkedList<T> {

    public MyFunkyList(){
    }

    public LinkedList<T> funkyFilter(MyFunkyInterface<T> funky){
        LinkedList<T> filtered = new LinkedList<>();
        for (T t : this){
            if (funky.doSomething(t)){
                filtered.add(t);
            }
        }
        return filtered;
    }

    public LinkedList<T> funkyFilter(MyIntegerFunkyInterface funky){
        LinkedList<T> filtered = new LinkedList<>();
        for (T t : this){
            if (funky.doSomething(t)){
                filtered.add(t);
            }
        }
        return filtered;
    }

}
