package com.alexander.java.example.java8.interfaces;

/**
 * Created by alexhopgood on 06/03/17.
 */
public class OverridingChild extends OverridingParent implements Child {

//    @Override
    public String method(){
        return "I'm an Overriding class of the OverridingParent and an implementor of Child";
    }
}
