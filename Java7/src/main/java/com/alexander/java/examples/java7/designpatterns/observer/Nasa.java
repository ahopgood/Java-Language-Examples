package com.alexander.java.examples.java7.designpatterns.observer;

/**
 * Created by alexhopgood on 27/04/17.
 */
public class Nasa implements LandingObserver {
    @Override
    public void observeLanding(String name) {
        if (name.contains("Apollo")){
            System.out.println("We made it!");
        }
    }
}
