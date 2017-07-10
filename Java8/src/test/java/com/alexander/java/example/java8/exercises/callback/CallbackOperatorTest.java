package com.alexander.java.example.java8.exercises.callback;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CallbackOperatorTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCallbackOperator_variable(){
        CallbackOperator op = new VariableCallbackOperator();
        assertTrue("I'm a callback Implementation class"
                .equalsIgnoreCase(op.setupCallback()));

    }

    @Test
    public void testCallbackOperator_staticInnerClass(){
        CallbackOperator op = new InnerclassCallbackOperator();
        assertTrue("I'm a callback inner class"
                .equalsIgnoreCase(op.setupCallback()));

    }

    @Test
    public void testCallbackOperator_lambda(){
        CallbackOperator op = new LambdaCallbackOperator();
        assertTrue("I'm a callback lambda"
                .equalsIgnoreCase(op.setupCallback()));

    }
}