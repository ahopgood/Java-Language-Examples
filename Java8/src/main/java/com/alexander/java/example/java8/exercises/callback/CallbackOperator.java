package com.alexander.java.example.java8.exercises.callback;

public abstract class CallbackOperator {

    public String performCallback(Callback callback){
        return callback.callback();
    }
    
    public abstract String setupCallback();
}
