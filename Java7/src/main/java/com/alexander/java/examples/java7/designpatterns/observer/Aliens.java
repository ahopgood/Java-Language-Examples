package com.alexander.java.examples.java7.designpatterns.observer;

/**
 * Created by alexhopgood on 27/04/17.
 */
public class Aliens implements LandingObserver {
    @Override
    public void observeLanding(String name) {
        if (name.contains("Apollo")){
            System.out.println("They're distracted, lets invade earth!");
        }
    }
}
