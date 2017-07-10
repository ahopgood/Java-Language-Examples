package com.alexander.java.example.java8.exercises.callback;

/**
 * Created by Alexander on 10/07/2017.
 */
public class LambdaCallbackOperator extends CallbackOperator {
    @Override
    public String setupCallback() {
        return super.performCallback( () -> "I'm a callback lambda");
    }
}
