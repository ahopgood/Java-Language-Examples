package com.alexander.java.example.java8.exercises.callback;

/**
 * Created by Alexander on 10/07/2017.
 */
public class InnerclassCallbackOperator extends CallbackOperator {
    @Override
    public String setupCallback() {
        return super.performCallback(new Callback(){
            public String callback() {
                return "I'm a callback inner class";
            }
        });
    }
}
