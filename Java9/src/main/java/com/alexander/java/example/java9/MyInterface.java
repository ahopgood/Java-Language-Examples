package com.alexander.java.example.java9;

//Able to use the Diamond operator here
public interface MyInterface<S> {

    private String greetingComposer(String greeting, S name) {
        return greeting + " " + name;
    }

    default String defaultGreeting(S name) {
        return greetingComposer("Hello", name);
    }
}
