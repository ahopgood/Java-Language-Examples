package com.alexander.java.example.java8.exercises.callback;

/**
 * Created by Alexander on 10/07/2017.
 */
public class VariableCallbackOperator extends CallbackOperator {
    @Override
    public String setupCallback() {
        Callback cb = new CallbackImpl();
        return super.performCallback(cb);
    }
}
