package com.alexander.java.examples.java7.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexhopgood on 27/04/17.
 */
public class Moon {
    private final List<LandingObserver> observers = new ArrayList<>();

    public void land(String name){
        for (LandingObserver observer : observers){
            observer.observeLanding(name);
        }
    }

    public void startSpying(LandingObserver observer){
        observers.add(observer);
    }

    public static void main(String[] args){
        Moon moon = new Moon();
        moon.startSpying(new Nasa());
        moon.startSpying(new Aliens());

        moon.land("An asteroid");
        moon.land("Apollo");
    }
}
